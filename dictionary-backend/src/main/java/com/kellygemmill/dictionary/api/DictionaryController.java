package com.kellygemmill.dictionary.api;

import com.kellygemmill.dictionary.model.Dictionary;
import com.kellygemmill.dictionary.model.DictionaryType;
import com.kellygemmill.dictionary.model.Entry;
import com.kellygemmill.dictionary.model.Word;
import com.kellygemmill.dictionary.service.DictionaryService;
import com.kellygemmill.dictionary.service.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "*")
public class DictionaryController {

    private final LookupService lookupService;
    private final DictionaryService dictionaryService;

    @Autowired
    public DictionaryController(LookupService lookupService, DictionaryService dictionaryService) {
        this.lookupService = lookupService;
        this.dictionaryService = dictionaryService;
    }

    @GetMapping("/dictionaries")
    List<Dictionary> getDictionaries(@RequestParam(name="type", required = false) DictionaryType type) {
        if (type == null) {
            return dictionaryService.listAllDictionaries();
        }
        return dictionaryService.listDictionaryByType(type);
    }

    @GetMapping("/parse/{query}")
    List<Word> parse(@PathVariable String query) {
        return lookupService.parse(query);
    }

    @GetMapping("/define/{query}")
    List<Entry> define(@PathVariable String query) {
        return lookupService.define(query);
    }

}
