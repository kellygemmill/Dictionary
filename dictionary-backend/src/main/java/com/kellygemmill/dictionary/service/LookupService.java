package com.kellygemmill.dictionary.service;

import com.kellygemmill.dictionary.model.Word;
import com.kellygemmill.dictionary.service.parser.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LookupService {

    private final ParserService parserService;

    @Autowired
    public LookupService(@Qualifier("kuromoji") ParserService parserService) {
        this.parserService = parserService;
    }

    public List<Word> parse(String query) {
        return parserService.parseInput(query);
    }
}
