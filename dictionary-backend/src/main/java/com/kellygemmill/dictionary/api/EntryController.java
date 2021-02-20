package com.kellygemmill.dictionary.api;

import com.kellygemmill.dictionary.model.DictionaryType;
import com.kellygemmill.dictionary.model.Entry;
import com.kellygemmill.dictionary.model.Word;
import com.kellygemmill.dictionary.service.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "*")
public class EntryController {

    private final LookupService lookupService;

    @Autowired
    public EntryController(LookupService lookupService) {
        this.lookupService = lookupService;
    }

    @GetMapping("/parse/{query}")
    List<Word> parse(@PathVariable String query) {
        return lookupService.parse(query);
    }

    @GetMapping("/entry")
    List<Entry> getEntries() {
        return lookupService.getEntries();
    }

    @GetMapping("/entry/{query}")
    List<Entry> getEntries(
            @PathVariable String query,
            @RequestParam(name="deConjugate", defaultValue = "true") boolean deConjugate,
            @RequestParam(name="dictionaryType", required = false) DictionaryType dictionaryType,
            @RequestParam(name="dictionaryId", required = false) Long dictionaryId
    ) {
        return lookupService.getEntries(query, deConjugate, dictionaryType, dictionaryId);
    }

    @PostMapping("/entry")
    ResponseEntity<?> createEntry(@Valid @RequestBody List<Entry> entries) throws URISyntaxException {
        List<Entry> result = lookupService.addEntry(entries);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/entry")
    ResponseEntity<?> updateEntry(@Valid @RequestBody List<Entry> entries) throws URISyntaxException {
        List<Entry> result = lookupService.addEntry(entries);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/entry/{id}")
    ResponseEntity<?> deleteEntry(@PathVariable Long id) {
        lookupService.deleteEntryById(id);
        return ResponseEntity.ok().build();
    }

}
