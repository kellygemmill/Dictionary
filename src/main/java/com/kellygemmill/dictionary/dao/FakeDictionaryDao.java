package com.kellygemmill.dictionary.dao;

import com.kellygemmill.dictionary.model.DictionaryEntry;
import com.kellygemmill.dictionary.model.Dictionary;
import com.kellygemmill.dictionary.model.Word;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FakeDictionaryDao implements DictionaryDao {

    Map<String,Dictionary> dictionaries;

    public FakeDictionaryDao() {
        this.dictionaries = new HashMap<>();
    }

    @Override
    public List<List<DictionaryEntry>> getDefinitions(Word query) {
        return dictionaries
                .keySet()
                .stream()
                .map(dictionary -> this.getDefinitions(query,dictionary))
                .collect(Collectors.toList());
    }

    @Override
    public List<DictionaryEntry> getDefinitions(Word query, String dictionary) {
        return dictionaries.get(dictionary).getDefinition(query);
    }

    @Override
    public void addDefinition(DictionaryEntry dictionaryEntry, String dictionaryName) {
        dictionaries.get(dictionaryName).addDefinition(dictionaryEntry);
    }

    @Override
    public void addDictionary(String name, Dictionary dictionary) {
        dictionaries.put(name, dictionary);
    }

}
