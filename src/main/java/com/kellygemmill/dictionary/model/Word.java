package com.kellygemmill.dictionary.model;

import java.util.Optional;

public class Word {

    private final String word;
    private final String reading;
    private final String partOfSpeech;
    private Word baseForm;

    public Word(String word, String reading, String partOfSpeech, Word baseForm) {
        this.word = word;
        this.reading = reading;
        this.partOfSpeech = partOfSpeech;
        this.baseForm = baseForm;
    }

    public Word(String word, String reading, String partOfSpeech) {
        this(word,reading,partOfSpeech,null); // make baseForm null if it's not passed
    }

    public String getWord() {
        return word;
    }

    public String getReading() {
        return reading;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public Optional<Word> getBaseForm() {
        return Optional.ofNullable(baseForm);
    }

    public void setBaseForm(Word baseForm) {
        this.baseForm = baseForm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word that = (Word) o;
        return word.equals(that.word) &&
                reading.equals(that.reading);
    }

    @Override
    public int hashCode() {
        return (word + " " + reading).hashCode();
    }

    @Override
    public String toString() {
        return word;
    }
}
