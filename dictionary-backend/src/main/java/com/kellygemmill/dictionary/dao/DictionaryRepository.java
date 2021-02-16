package com.kellygemmill.dictionary.dao;

import com.kellygemmill.dictionary.model.Dictionary;
import com.kellygemmill.dictionary.model.DictionaryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictionaryRepository extends JpaRepository<Dictionary, Long> {
    public List<Dictionary> getDictionaryByName(String name);
    public List<Dictionary> getDictionaryByType(DictionaryType dictionaryType);

//    public List<Dictionary> getDictionaryByType(DictionaryType type);
}
