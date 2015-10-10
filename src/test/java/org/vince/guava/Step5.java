package org.vince.guava;

import org.junit.Test;
import org.vince.guava.mm.EnglishWord;
import org.vince.guava.mm.Kanji;
import org.vince.guava.mm.KanjiDic;
import org.vince.guava.mm.Meaning;

import javax.xml.bind.JAXB;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by vincent on 06/10/15.
 */
public class Step5 {

    @Test
    public void testKanji() {
        KanjiDic kanjiDic = JAXB.unmarshal(
            this.getClass().getClassLoader().getResourceAsStream("kanji.xml"),
            KanjiDic.class
        );

        assertEquals(6355,kanjiDic.getKanji().size());

        HashMap<String, List<EnglishWord>> index = new HashMap<String, List<EnglishWord>>();

        // Indexer dans un Map un Character Kanji avec la liste de ses sens
        for (Kanji kanji : kanjiDic.getKanji()) {
            if(kanji.getMeaning() == null) continue;

            for (Meaning meaning : kanji.getMeaning()) {
                List<EnglishWord> meanings = index.get(meaning.getValue());
                if (meanings == null) {
                    meanings = new ArrayList<EnglishWord>();
                    index.put(meaning.getValue(), meanings);
                }
                meanings.add(new EnglishWord(kanji, meaning.getValue()));
            }
        }

        // Cas de test "car"
        List<EnglishWord> carResult = index.get("car");
        assertEquals(1, carResult.size());
        assertEquals("車", carResult.get(0).getKanji().getCharacter());

        // Cas de test sur "house"
        Collection<EnglishWord> houseResult = index.get("house");
        StringBuilder buffer = new StringBuilder();
        boolean isFirst = true;
        for (EnglishWord englishWord : houseResult) {
            if(!isFirst) {
                buffer.append(",");
            }
            buffer.append(englishWord.getKanji().getCharacter());
            isFirst = false;

        }

        assertEquals(10, houseResult.size());
        assertEquals(
            "宇,屋,家,舎,宅,内,房,厦,廈,舍",
            buffer.toString()
        );
    }
}
