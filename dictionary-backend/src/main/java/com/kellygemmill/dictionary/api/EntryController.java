package com.kellygemmill.dictionary.api;

import com.kellygemmill.dictionary.model.DictionaryType;
import com.kellygemmill.dictionary.model.Entry;
import com.kellygemmill.dictionary.model.Word;
import com.kellygemmill.dictionary.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/")
//@CrossOrigin(origins = "*")
public class EntryController {

    private final EntryService entryService;

    @Autowired
    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping("/parse/{query}")
    List<Word> parse(@PathVariable String query) {
        return entryService.parse(query);
    }

    @GetMapping("/entry")
    List<Entry> getEntries() {
        return entryService.getEntries();
    }

    @GetMapping("/entry/{query}")
    List<Entry> getEntriesByQuery(
            @PathVariable String query,
            @RequestParam(name="deConjugate", defaultValue = "true") boolean deConjugate,
            @RequestParam(name="dictionaryType", required = false) DictionaryType dictionaryType,
            @RequestParam(name="dictionaryId", required = false) Long dictionaryId
    ) {
        return entryService.getEntriesByQuery(query, deConjugate, dictionaryType, dictionaryId);
    }

    @PostMapping("/entry")
    ResponseEntity<?> createEntry(@Valid @RequestBody List<Entry> entries) throws URISyntaxException {
        List<Entry> result = entryService.addEntry(entries);
        return ResponseEntity.created(new URI("/api/entry/")).body(result);
    }

    @PutMapping("/entry")
    ResponseEntity<?> updateEntry(@Valid @RequestBody Entry entry) throws URISyntaxException {
        Optional<Entry> result = entryService.updateEntry(entry);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/entry")
    ResponseEntity<?> deleteAll() {
        entryService.deleteEntries();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/entry/{id}")
    ResponseEntity<?> deleteEntryById(@PathVariable Long id) {
        entryService.deleteEntryById(id);
        return ResponseEntity.ok().build();
    }

}
