package org.vince.guava;

import org.junit.Assert;
import org.junit.Test;
import org.vince.guava.mm.KanjiDic;

import javax.xml.bind.JAXB;
import java.io.File;

import static org.junit.Assert.*;

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
    }
}
