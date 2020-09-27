package com.kellygemmill.dictionary.model;

public class Word {

    private final String surfaceForm;
    private final String reading;
    private final String partOfSpeech;
    private final String baseForm;

    public Word(String surfaceForm, String reading, String partOfSpeech, String baseForm) {
        this.surfaceForm = surfaceForm;
        this.reading = reading;
        this.partOfSpeech = partOfSpeech;
        this.baseForm = baseForm;
    }

    public String getSurfaceForm() {
        return surfaceForm;
    }

    public String getReading() {
        return reading;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public String getBaseForm() {
        return baseForm;
    }

    @Override
    public String toString() {
        return surfaceForm;
    }
}
