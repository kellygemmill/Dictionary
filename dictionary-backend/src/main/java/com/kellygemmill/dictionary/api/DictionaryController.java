package com.kellygemmill.dictionary.api;

import com.kellygemmill.dictionary.model.Dictionary;
import com.kellygemmill.dictionary.model.DictionaryType;
import com.kellygemmill.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "*")
public class DictionaryController {

    private final DictionaryService dictionaryService;

    @Autowired
    public DictionaryController(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @GetMapping("/")
    ResponseEntity<?> pingApi() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/dictionary")
    List<Dictionary> getDictionaries(@RequestParam(name="type", required = false) DictionaryType dictionaryType) {
        return dictionaryService.getDictionaries(dictionaryType);
    }

    @GetMapping("/dictionary/{id}")
    ResponseEntity<?> getDictionary(@PathVariable Long id) {
        Optional<Dictionary> dictionary = dictionaryService.getDictionaryById(id);
        return dictionary
                .map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/dictionary")
    ResponseEntity<Dictionary> createDictionary(@Valid @RequestBody Dictionary dictionary) throws URISyntaxException {
        Dictionary result = dictionaryService.addDictionary(dictionary);
        return ResponseEntity.created(new URI("/api/dictionary/" + result.getId())).body(result);
    }

    @PutMapping("/dictionary")
    ResponseEntity<Dictionary> updateDictionary(@Valid @RequestBody Dictionary dictionary) {
        Dictionary result = dictionaryService.updateDictionary(dictionary);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/dictionary/{id}")
    ResponseEntity<?> deleteDictionary(@PathVariable Long id) {
        dictionaryService.deleteDictionaryById(id);
        return ResponseEntity.ok().build();
    }

}
