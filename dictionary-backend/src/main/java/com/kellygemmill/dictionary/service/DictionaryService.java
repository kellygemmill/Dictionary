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

    public List<Dictionary> getDictionaries(DictionaryType dictionaryType, Long dictionaryId) {

        if (dictionaryId != null) {
            return listDictionaryById(dictionaryId);
        }

        if (dictionaryType != null) {
            return listDictionaryByType(dictionaryType);
        }

        return listAllDictionaries();

    }

    private List<Dictionary> listAllDictionaries() {
        return dictionaryRepository.findAll();
    }

    private List<Dictionary> listDictionaryById(Long dictionaryId) {
        return dictionaryRepository.getDictionaryById(dictionaryId);
    }

    private List<Dictionary> listDictionaryByType(DictionaryType dictionaryType) {
        return dictionaryRepository.getDictionaryByType(dictionaryType);
    }

}
