package com.kellygemmill.dictionary.dao;

import com.kellygemmill.dictionary.model.Dictionary;
import com.kellygemmill.dictionary.model.DictionaryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictionaryRepository extends JpaRepository<Dictionary, Long> {

    @Query("SELECT d FROM Dictionary d")
    List<Dictionary> getAllDictionaries();

    @Query("SELECT d FROM Dictionary d WHERE d.type = ?1")
    public List<Dictionary> getDictionaryByType(DictionaryType type);

    @Query("SELECT d FROM Dictionary d WHERE d.name = ?1")
    public List<Dictionary> getDictionaryByName(String name);

    @Query("SELECT d FROM Dictionary d WHERE d.type = ?1 AND d.name = ?2")
    public List<Dictionary> getDictionaryByTypeAndName(DictionaryType dictionaryType, String name);

}
