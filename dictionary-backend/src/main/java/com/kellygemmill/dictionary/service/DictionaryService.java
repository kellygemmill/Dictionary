package com.kellygemmill.dictionary.service;

import com.kellygemmill.dictionary.dao.DictionaryRepository;
import com.kellygemmill.dictionary.model.Dictionary;
import com.kellygemmill.dictionary.model.DictionaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DictionaryService {

    private final DictionaryRepository dictionaryRepository;

    @Autowired
    public DictionaryService(DictionaryRepository dictionaryRepository) {
        this.dictionaryRepository = dictionaryRepository;
    }

    public Optional<Dictionary> getDictionaryById(Long dictionaryId) {
        return dictionaryRepository.findDictionaryById(dictionaryId);
    }

    public List<Dictionary> getDictionaries(DictionaryType dictionaryType) {

        return dictionaryType == null ?
                dictionaryRepository.findAll() :
                dictionaryRepository.findDictionaryByType(dictionaryType);
    }

    public Dictionary addDictionary(Dictionary dictionary) {
        return dictionaryRepository.save(dictionary);
    }

    public void deleteDictionaryById(Long id) {
        dictionaryRepository.deleteById(id);
    }

}
