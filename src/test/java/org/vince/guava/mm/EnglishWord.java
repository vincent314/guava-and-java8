package org.vince.guava.mm;

/**
 * Created by vincent on 08/10/15.
 */
public class EnglishWord {
    private Kanji kanji;

    private String meaning;

    public EnglishWord(Kanji kanji, String meaning) {
        this.kanji = kanji;
        this.meaning = meaning;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public Kanji getKanji() {
        return kanji;
    }

    public void setKanji(Kanji kanji) {
        this.kanji = kanji;
    }
}
