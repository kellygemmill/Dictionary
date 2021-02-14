package com.kellygemmill.dictionary.service.parser;

import com.kellygemmill.dictionary.model.Word;
import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("kuromoji")
public class KuromojiParser implements ParserService {

    private final Tokenizer normal; // Use "normal" mode
    private final Tokenizer search; // Use "search" mode

    public KuromojiParser() {
        this.normal = Tokenizer.builder().mode(Tokenizer.Mode.NORMAL).build();
        this.search = Tokenizer.builder().mode(Tokenizer.Mode.SEARCH).build();
    }

    @Override
    public List<Word> parseInput(String query) {
        return getTokens(query)
                .stream()
                .map(this::tokenToWord)
                .distinct()
                .collect(Collectors.toList());
    }

    private List<Token> getTokens(String query) {
        List<Token> tokens = new ArrayList<>();
        tokens.addAll(normal.tokenize(query));
        tokens.addAll(search.tokenize(query));
        return tokens;
    }

    private Word tokenToWord(Token token) {
        String surfaceForm = token.getSurfaceForm();
        String baseForm = token.getBaseForm();

        Word word = new Word(
                surfaceForm,
                token.getReading(),
                token.getPartOfSpeech());

        if (!baseForm.equals(surfaceForm)) {  // Get the base word if necessary
            Token baseFormToken = getTokens(baseForm).get(0); // Already base form, so token list size is 1
            word.setBaseForm(tokenToWord(baseFormToken));
        }

        return word;
    }

}
