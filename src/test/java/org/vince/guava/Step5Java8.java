package org.vince.guava;

import org.junit.Rule;
import org.junit.Test;
import org.vince.guava.mm.EnglishWord;
import org.vince.guava.mm.KanjiDic;

import javax.xml.bind.JAXB;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class Step5Java8 {

    @Rule
    public StopWatchRule stopWatch = new StopWatchRule();

    @Test
    public void testKanji() {

        // -------------------- GIVEN -------------------------------
        // Lecture du dictionnaire
        KanjiDic kanjiDic = JAXB.unmarshal(
            this.getClass().getClassLoader().getResourceAsStream("kanji.xml"),
            KanjiDic.class
        );

        assertEquals(6355, kanjiDic.getKanji().size());

        // --------------------- THEN --------------------------
        // Indexer Kanji --> sens
        Map<String, List<EnglishWord>> EnglishDic = kanjiDic.getKanji()
            .parallelStream()
            .filter((kanji -> kanji.getMeaning() != null))
            .flatMap(kanji -> kanji.getMeaning()
                    .parallelStream()
                    .map(meaning -> new EnglishWord(kanji, meaning.getValue()))
            ).collect(
                Collectors.groupingBy(EnglishWord::getMeaning)
            );


        // ------------------------ EXPECT --------------------------
        // Cas de test "car"
        Collection<EnglishWord> carResult = EnglishDic.get("car");
        assertEquals(1, carResult.size());
        assertEquals("車", carResult.iterator().next().getKanji().getCharacter());

        // Cas de test sur "house"
        Collection<EnglishWord> houseResult = EnglishDic.get("house");

        assertEquals(10, houseResult.size());
        assertEquals(
            "宇,屋,家,舎,宅,内,房,厦,廈,舍",
            houseResult.stream()
                .map(englishWord -> englishWord.getKanji().getCharacter())
                .collect(Collectors.joining(","))
        );
    }
}
