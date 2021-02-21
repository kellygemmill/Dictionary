package com.kellygemmill.dictionary.service;

import com.kellygemmill.dictionary.dao.EntryRepository;
import com.kellygemmill.dictionary.model.DictionaryType;
import com.kellygemmill.dictionary.model.Entry;
import com.kellygemmill.dictionary.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kellygemmill.dictionary.model.DictionaryType.*;

@Service
public class LookupService {

    private final ParserService parserService;
    private final EntryRepository entryRepository;

    @Autowired
    public LookupService(@Qualifier("kuromoji") ParserService parserService,
                         EntryRepository entryRepository) {
        this.parserService = parserService;
        this.entryRepository = entryRepository;
    }

    public List<Word> parse(String query) {
        return parserService.parseInput(query);
    }

    public List<Entry> getEntries() {
        return entryRepository.findAll();
    }

    public List<Entry> getEntriesByQuery(String query, boolean deConjugate, DictionaryType dictionaryType, Long dictionaryId) {
        String wordToFind = deConjugate ? parse(query).get(0).getBaseForm() : query; // Assumes only looking up first word in query

        return findWord(wordToFind, dictionaryType, dictionaryId);
    }

    public List<Entry> addEntry(List<Entry> entries) {
        return entryRepository.saveAll(entries);
    }

    public void deleteEntries() {
        entryRepository.deleteAll();
    }

    public void deleteEntryById(Long id) {
        entryRepository.deleteById(id);
    }

    private List<Entry> findWord(String word, DictionaryType dictionaryType, Long dictionaryId) {
        if (dictionaryId != null) {
            return getEntriesByWordAndDictionaryId(word, dictionaryId);
        }

        if (dictionaryType != null && dictionaryType != ALL) {
            return getEntriesByWordAndDictionaryType(word, dictionaryType);
        }

        return getEntriesByWord(word);

    }

    private List<Entry> getEntriesByWord(String word) {
        return entryRepository.findByWord(word);
    }

    private List<Entry> getEntriesByWordAndDictionaryType(String word, DictionaryType dictionaryType) {
        if (dictionaryType == EtoJ) {
            return entryRepository.findByDefinition(" " + word + " ");
        }
        return entryRepository.findByWordAndDictionaryType(word, dictionaryType);
    }

    private List<Entry> getEntriesByWordAndDictionaryId(String word, Long dictionaryId) {
        return entryRepository.findByWordAndDictionaryId(word, dictionaryId);
    }

}
