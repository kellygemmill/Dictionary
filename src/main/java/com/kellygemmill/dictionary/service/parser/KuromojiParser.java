package com.kellygemmill.dictionary.service.parser;

import com.kellygemmill.dictionary.model.Word;
import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("kuromoji")
public class KuromojiParser implements ParserService {

    private final Tokenizer tokenizer;

    public KuromojiParser() {
        this.tokenizer = Tokenizer.builder().build();
    }

    private List<Token> getTokens(String query) {
        return tokenizer.tokenize(query);
    }

    private Word tokenToWord(Token token) {
        return new Word(
                token.getSurfaceForm(),
                token.getReading(),
                token.getPartOfSpeech(),
                token.getBaseForm()
        );
    }

    @Override
    public List<Word> parseInput(String query) {
        return getTokens(query)
                .stream()
                .map(this::tokenToWord)
                .collect(Collectors.toList());
    }
}
