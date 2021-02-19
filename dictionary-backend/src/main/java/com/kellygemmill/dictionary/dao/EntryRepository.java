package com.kellygemmill.dictionary.dao;

import com.kellygemmill.dictionary.model.DictionaryType;
import com.kellygemmill.dictionary.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {

    @Query("SELECT e FROM Entry e WHERE e.word = ?1 OR e.reading = ?1 OR e.definition LIKE %?1%")
    public List<Entry> getEntryByWord(String word);

    @Query("SELECT e FROM Entry e WHERE (e.word = ?1 OR e.reading = ?1) AND e.dictionary.type = ?2")
    public List<Entry> getEntryByWordAndDictionaryType(String word, DictionaryType type);

    @Query("SELECT e FROM Entry e WHERE (e.word = ?1 OR e.reading = ?1) AND e.dictionary.id = ?2")
    public List<Entry> getEntryByWordAndDictionaryId(String word, Long dictionaryId);

    @Query("SELECT e FROM Entry e WHERE e.definition LIKE %?1%")
    public List<Entry> getEntryByDefinition(String word);
}
