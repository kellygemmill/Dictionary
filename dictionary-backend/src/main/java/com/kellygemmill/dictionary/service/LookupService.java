package com.kellygemmill.dictionary.service;

import com.kellygemmill.dictionary.dao.EntryRepository;
import com.kellygemmill.dictionary.model.Entry;
import com.kellygemmill.dictionary.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    public List<Entry> define(String query) {
        return parse(query)
                .stream()
                .map(this::getEntryByWord)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public List<Entry> getEntryByWord(Word word) {
        Set<Entry> entries = new HashSet<>();
        entries.addAll(entryRepository.findEntryByWord(word.getBaseForm()));
        entries.addAll(entryRepository.getEntryByReading(word.getBaseForm()));

        return new ArrayList<>(entries);
    }
}
