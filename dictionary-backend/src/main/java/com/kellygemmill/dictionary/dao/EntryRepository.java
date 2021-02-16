package com.kellygemmill.dictionary.dao;

import com.kellygemmill.dictionary.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {
    public List<Entry> findEntryByWord(String word);
    public List<Entry> getEntryByReading(String word);
}
