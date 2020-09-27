package com.kellygemmill.dictionary.api;

import com.kellygemmill.dictionary.service.TranslationService;
import org.atilika.kuromoji.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
//@CrossOrigin(origins = "*")
public class DictionaryController {

    private final TranslationService translationService;

    @Autowired
    public DictionaryController(TranslationService translationService) {
        this.translationService = translationService;
    }

    @GetMapping("/parse/{query}")
    List<Token> translateQuery(@PathVariable String query) {
        return translationService.translate(query);
    }

}
