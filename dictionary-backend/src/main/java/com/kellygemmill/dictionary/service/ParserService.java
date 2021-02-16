package com.kellygemmill.dictionary.service;

import com.kellygemmill.dictionary.model.Word;

import java.util.List;

public interface ParserService {

    public List<Word> parseInput(String input);

}
