package com.kellygemmill.dictionary.api;

import com.kellygemmill.dictionary.dao.EntryRepository;
import com.kellygemmill.dictionary.model.Entry;
import com.kellygemmill.dictionary.model.Word;
import com.kellygemmill.dictionary.service.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "*")
public class DictionaryController {

    private final LookupService lookupService;
    private final EntryRepository entryRepository;

    @Autowired
    public DictionaryController(LookupService lookupService, EntryRepository entryRepository) {
        this.lookupService = lookupService;
        this.entryRepository = entryRepository;
    }

    @GetMapping("/parse/{query}")
    List<Word> lookupQuery(@PathVariable String query) {
        return lookupService.parse(query);
    }

    @GetMapping("/define/{query}")
    List<Entry> defineQuery(@PathVariable String query) {
        return entryRepository.getEntryByWord(lookupService.parse(query).get(0).getBaseForm());
    }

}
