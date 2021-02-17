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

    public List<Entry> define(String query, boolean deConjugate, DictionaryType dictionaryType, Long dictionaryId) {
        return parse(query)
                .stream()
                .map(word -> deConjugate ? word.getBaseForm() : word.getWord())
                .map(word -> lookUpWord(word, dictionaryType, dictionaryId))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public List<Entry> lookUpWord(String word, DictionaryType dictionaryType, Long dictionaryId) {

        if (dictionaryId != null) {
            return getEntryByWordAndDictionaryId(word, dictionaryId);
        }

        if (dictionaryType != null) {
            return getEntryByWordAndDictionaryType(word, dictionaryType);
        }

        return getEntryByWord(word);

    }

    private List<Entry> getEntryByWord(String word) {
        return entryRepository.getEntryByWord(word);
    }

    private List<Entry> getEntryByWordAndDictionaryType(String word, DictionaryType dictionaryType) {
        return entryRepository.getEntryByWordAndDictionaryType(word, dictionaryType);
    }

    private List<Entry> getEntryByWordAndDictionaryId(String word, Long dictionaryId) {
        return entryRepository.getEntryByWordAndDictionaryId(word, dictionaryId);
    }

}
