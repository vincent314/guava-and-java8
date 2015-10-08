package org.vince.guava.mm;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.List;

public class Kanji {

    private String character;

    private List<Reading> reading;

    private List<Meaning> meaning;

    @XmlAttribute(name="char")
    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public List<Reading> getReading() {
        return reading;
    }

    public void setReading(List<Reading> reading) {
        this.reading = reading;
    }

    public List<Meaning> getMeaning() {
        return meaning;
    }

    public void setMeaning(List<Meaning> meaning) {
        this.meaning = meaning;
    }
}
