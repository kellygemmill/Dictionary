package com.kellygemmill.dictionary.model;

public class DictionaryEntry {

    private final String word;
    private final String reading;
    private final String definition;

    public DictionaryEntry(String word, String reading, String definition) {
        this.word = word;
        this.reading = reading;
        this.definition = definition;
    }

    public String getWord() {
        return word;
    }

    public String getReading() {
        return reading;
    }

    public String getDefinition() {
        return definition;
    }
}
