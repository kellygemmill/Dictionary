package com.kellygemmill.dictionary.service;

import com.kellygemmill.dictionary.dao.DictionaryRepository;
import com.kellygemmill.dictionary.model.Dictionary;
import com.kellygemmill.dictionary.model.DictionaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryService {

    private final DictionaryRepository dictionaryRepository;

    @Autowired
    public DictionaryService(DictionaryRepository dictionaryRepository) {
        this.dictionaryRepository = dictionaryRepository;
    }

    public List<Dictionary> listAllDictionaries() {
        return dictionaryRepository.findAll();
    }

    public List<Dictionary> listDictionaryByType(DictionaryType dictionaryType) {
        return dictionaryRepository.getDictionaryByType(dictionaryType);
    }
}
