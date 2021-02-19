package com.kellygemmill.dictionary.service;

import com.kellygemmill.dictionary.dao.EntryRepository;
import com.kellygemmill.dictionary.model.DictionaryType;
import com.kellygemmill.dictionary.model.Entry;
import com.kellygemmill.dictionary.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Entry> getEntries(String query, boolean deConjugate, DictionaryType dictionaryType, Long dictionaryId) {
        String wordToFind = deConjugate ? parse(query).get(0).getBaseForm() : query; // Assumes only looking up first word in query

        return findWord(wordToFind, dictionaryType, dictionaryId);
    }

    public List<Entry> findWord(String word, DictionaryType dictionaryType, Long dictionaryId) {

        if (dictionaryId != null) {
            return getEntriesByWordAndDictionaryId(word, dictionaryId);
        }

        if (dictionaryType != null && dictionaryType != ALL) {
            return getEntriesByWordAndDictionaryType(word, dictionaryType);
        }

        return getEntriesByWord(word);

    }

    private List<Entry> getEntriesByWord(String word) {
        return entryRepository.getEntryByWord(word);
    }

    private List<Entry> getEntriesByWordAndDictionaryType(String word, DictionaryType dictionaryType) {
        if (dictionaryType == EtoJ) {
            return entryRepository.getEntryByDefinition(word);
        }
        return entryRepository.getEntryByWordAndDictionaryType(word, dictionaryType);
    }

    private List<Entry> getEntriesByWordAndDictionaryId(String word, Long dictionaryId) {
        return entryRepository.getEntryByWordAndDictionaryId(word, dictionaryId);
    }

    public Entry addEntry(Entry entry) {
        return entryRepository.save(entry);
    }

    public void deleteEntryById(Long id) {
        entryRepository.deleteById(id);
    }
}
