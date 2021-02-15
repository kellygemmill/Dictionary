package com.kellygemmill.dictionary.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Dictionary")
@Table(name = "dictionary")
public class Dictionary {

    @Id
    @SequenceGenerator(name = "dictionary_sequence", sequenceName = "dictionary_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dictionary_generator")
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private java.lang.String name;

    @Column(name = "type", nullable = false, length = 11)
    @Convert(converter = TypeAttributeConverter.class)
    private DictionaryType type;

    @OneToMany(mappedBy = "dictionary", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private List<Entry> entries = new ArrayList<>();

    public Dictionary() {

    }

    public Dictionary(String name, DictionaryType type) {
        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DictionaryType getType() {
        return type;
    }

    public void setType(DictionaryType type) {
        this.type = type;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }
}
