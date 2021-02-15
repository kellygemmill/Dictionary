package com.kellygemmill.dictionary.model;

import javax.persistence.*;

@Entity(name = "Entry")
@Table(name = "entry")
public class Entry {

    @Id
    @SequenceGenerator(name = "entry_sequence", sequenceName = "entry_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entry_generator")
    @Column(name = "id")
    private Long id;

    @Column(name = "word", nullable = false, columnDefinition = "TEXT")
    private String word;

    @Column(name = "reading", nullable = false, columnDefinition = "TEXT")
    private String reading;

    @Column(name = "definition", nullable = false, columnDefinition = "TEXT")
    private String definition;

    @ManyToOne
    @JoinColumn(name = "dictionary_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "entry_dictionary_fk"))
    private Dictionary dictionary;

    public Entry(){

    }

    public Entry(String word, String reading, String definition, Dictionary dictionary) {
        this.word = word;
        this.reading = reading;
        this.definition = definition;
        this.dictionary = dictionary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "word='" + word + '\'' +
                ", reading='" + reading + '\'' +
                ", definition='" + definition + '\'' +
                ", sourceDictionary=" + dictionary +
                '}';
    }
}
