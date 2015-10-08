package org.vince.guava;

import com.google.common.base.Function;
import com.google.common.collect.*;
import org.junit.Test;
import org.vince.guava.mm.EnglishWord;
import org.vince.guava.mm.Kanji;
import org.vince.guava.mm.KanjiDic;
import org.vince.guava.mm.Meaning;

import javax.xml.bind.JAXB;

import java.util.Collection;

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
            .transformAndConcat(new Function<Kanji, Iterable<EnglishWord>>() {
                @Override
                public Iterable<EnglishWord> apply(Kanji kanji) {
                    if (kanji.getMeaning() == null) {
                        return Lists.newArrayList();
                    }

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

        assertEquals(13, index.get("quiet").size());
    }
}
