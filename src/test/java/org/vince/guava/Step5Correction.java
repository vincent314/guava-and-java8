package org.vince.guava;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.*;
import org.junit.Test;
import org.vince.guava.mm.EnglishWord;
import org.vince.guava.mm.Kanji;
import org.vince.guava.mm.KanjiDic;
import org.vince.guava.mm.Meaning;

import javax.xml.bind.JAXB;

import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;

/**
 * Created by vincent on 06/10/15.
 */
public class Step5Correction {

    @Test
    public void testKanji() {
        KanjiDic kanjiDic = JAXB.unmarshal(
            this.getClass().getClassLoader().getResourceAsStream("kanji.xml"),
            KanjiDic.class
        );

        assertEquals(6355, kanjiDic.getKanji().size());

        ImmutableMap<String, Collection<EnglishWord>> index = FluentIterable.from(kanjiDic.getKanji())
            .filter(new Predicate<Kanji>() {
                @Override
                public boolean apply(Kanji kanji) {
                    return kanji.getMeaning() != null;
                }
            })
            .transformAndConcat(new Function<Kanji, Iterable<EnglishWord>>() {
                @Override
                public Iterable<EnglishWord> apply(Kanji kanji) {
                    return Iterables.transform(kanji.getMeaning(), new Function<Meaning, EnglishWord>() {
                        @Override
                        public EnglishWord apply(Meaning meaning) {
                            return new EnglishWord(kanji, meaning.getValue());
                        }
                    });
                }
            })
            .index(new Function<EnglishWord, String>() {
                @Override
                public String apply(EnglishWord englishWord) {
                    return englishWord.getMeaning();
                }
            }).asMap();

        // Cas de test "car"
        Collection<EnglishWord> carResult = index.get("car");
        assertEquals(1, carResult.size());
        assertEquals("車", carResult.iterator().next().getKanji().getCharacter());

        // Cas de test
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
