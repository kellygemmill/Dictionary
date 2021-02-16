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

    public List<Dictionary> getDictionaries(DictionaryType type, String name) {
        if (type == null && name == null) {
            return listAllDictionaries();
        }

        if (name == null) {
            return listDictionaryByType(type);
        }

        if (type == null) {
            return listDictionaryByName(name);
        }

        return listDictionaryByTypeAndName(type, name);

    }

    public List<Dictionary> listAllDictionaries() {
        return dictionaryRepository.findAll();
    }

    public List<Dictionary> listDictionaryByName(String name) {
        return dictionaryRepository.getDictionaryByName(name);
    }

    public List<Dictionary> listDictionaryByType(DictionaryType type) {
        return dictionaryRepository.getDictionaryByType(type);
    }

    public List<Dictionary> listDictionaryByTypeAndName(DictionaryType type, String name) {
        return dictionaryRepository.getDictionaryByTypeAndName(type,name);
    }

}
