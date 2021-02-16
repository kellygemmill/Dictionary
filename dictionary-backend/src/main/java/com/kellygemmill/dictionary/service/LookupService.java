package com.kellygemmill.dictionary.service;

import com.kellygemmill.dictionary.dao.EntryRepository;
import com.kellygemmill.dictionary.model.Entry;
import com.kellygemmill.dictionary.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Entry> getEntryByWord(String word) {
        return entryRepository.getEntryByWord(word);
    }
}
