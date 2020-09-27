package com.kellygemmill.dictionary.api;

import com.kellygemmill.dictionary.model.Word;
import com.kellygemmill.dictionary.service.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
//@CrossOrigin(origins = "*")
public class DictionaryController {

    private final LookupService lookupService;

    @Autowired
    public DictionaryController(LookupService lookupService) {
        this.lookupService = lookupService;
    }

    @GetMapping("/parse/{query}")
    List<Word> lookupQuery(@PathVariable String query) {
        return lookupService.parse(query);
    }

}
