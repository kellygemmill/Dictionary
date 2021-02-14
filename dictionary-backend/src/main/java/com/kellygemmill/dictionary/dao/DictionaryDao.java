package com.kellygemmill.dictionary.dao;

import com.kellygemmill.dictionary.model.DictionaryEntry;
import com.kellygemmill.dictionary.model.Dictionary;
import com.kellygemmill.dictionary.model.Word;

import java.util.List;

public interface DictionaryDao {

    public List<DictionaryEntry> getDefinitions(Word query, String dictionaryName);
    public List<List<DictionaryEntry>> getDefinitions(Word query);

    public void addDefinition(DictionaryEntry dictionaryEntry, String dictionaryName);
    public void addDictionary(String dictionaryName, Dictionary dictionary);

}
