package org.vince.guava.mm;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class KanjiDic {
    private List<Kanji> kanji;

    public List<Kanji> getKanji() {
        return kanji;
    }

    public void setKanji(List<Kanji> kanji) {
        this.kanji = kanji;
    }
}
