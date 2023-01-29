package com.uppgifter.uppgift3.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tags")
public class Tags {
    @Id
    @Column(name = "tags_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tagsId;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = { CascadeType.PERSIST })
    @JoinTable(
            name = "notes_tags",
            joinColumns = { @JoinColumn(name = "notes_id") },
            inverseJoinColumns = { @JoinColumn(name = "tags_id") }
    )
    private Set<Note> notes = new HashSet<>();

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    public Tags() {
    }

}