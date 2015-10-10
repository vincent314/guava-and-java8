package org.vince.guava;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import org.junit.Test;
import org.vince.guava.mm.EnglishWord;
import org.vince.guava.mm.KanjiDic;

import javax.xml.bind.JAXB;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by vincent on 06/10/15.
 */
public class Step5Java8 {

    @Test
    public void testKanji() {
        KanjiDic kanjiDic = JAXB.unmarshal(
            this.getClass().getClassLoader().getResourceAsStream("kanji.xml"),
            KanjiDic.class
        );

        assertEquals(6355, kanjiDic.getKanji().size());

        Map<String, List<EnglishWord>> index = kanjiDic.getKanji()
            .stream()
            .filter((kanji -> kanji.getMeaning() != null))
            .flatMap(kanji -> kanji.getMeaning()
                    .stream()
                    .map(meaning -> new EnglishWord(kanji, meaning.getValue()))
            ).collect(
                Collectors.groupingBy(EnglishWord::getMeaning)
            );

        // Cas de test "car"
        Collection<EnglishWord> carResult = index.get("car");
        assertEquals(1, carResult.size());
        assertEquals("車", carResult.iterator().next().getKanji().getCharacter());

        // Cas de test sur "house"
        Collection<EnglishWord> houseResult = index.get("house");

        assertEquals(10, houseResult.size());
        assertEquals(
            "宇,屋,家,舎,宅,内,房,厦,廈,舍",
            Joiner.on(",").join(
                Iterables.transform(
                    houseResult,
                    new Function<EnglishWord, String>() {
                        @Override
                        public String apply(EnglishWord englishWord) {
                            return englishWord.getKanji().getCharacter();
                        }
                    }
                )
            )
        );
    }
}
