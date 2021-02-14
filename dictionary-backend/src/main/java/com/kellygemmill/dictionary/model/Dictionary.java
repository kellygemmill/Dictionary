package com.kellygemmill.dictionary.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Dictionary {

    private final String name;
    private final Map<String, List<DictionaryEntry>> entries;

    public Dictionary(String name,Map<String,List<DictionaryEntry>> entries) {
        this.name = name;
        this.entries = entries;
    }

    public Dictionary(String name) {
        this(name, new HashMap<>());
    }

    public String getName() {
        return name;
    }

    public Map<String, List<DictionaryEntry>> getEntries() {
        return entries;
    }

    public List<DictionaryEntry> getDefinition(Word word) {
        List<DictionaryEntry> potentialEntries = entries.get(word.getReading());
        return potentialEntries
                .stream()
                .filter(entry -> entry.getWord().equals(word.getWord()))
                .collect(Collectors.toList());
    }

    public void addDefinition(DictionaryEntry dictionaryEntry) {
        String reading = dictionaryEntry.getReading();
        if (!entries.containsKey(reading)) {
            entries.put(reading,new ArrayList<>());
        }
        entries.get(reading).add(dictionaryEntry);
    }
}
