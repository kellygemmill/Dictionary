package com.kellygemmill.dictionary.dao;

import com.kellygemmill.dictionary.model.Dictionary;
import com.kellygemmill.dictionary.model.DictionaryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DictionaryRepository extends JpaRepository<Dictionary, Long> {

    @Query("SELECT d FROM Dictionary d")
    List<Dictionary> findAllDictionaries();

    @Query("SELECT d FROM Dictionary d WHERE d.type = ?1")
    public List<Dictionary> findDictionaryByType(DictionaryType dictionaryType);

    @Query("SELECT d FROM Dictionary d WHERE d.name = ?1")
    public Optional<Dictionary> findDictionaryById(Long dictionaryId);

}
