package com.kellygemmill.dictionary.service;

import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranslationService {

    private Tokenizer tokenizer;

    public TranslationService() {
        this.tokenizer = Tokenizer.builder().build();
    }

    public List<Token> translate(String query) {
        return tokenizer.tokenize(query);
    }
}
