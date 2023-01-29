package com.uppgifter.uppgift3.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "notes")
public class Note {
    @Id
    @Column(name = "notes_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notesId;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @ManyToMany(cascade = { CascadeType.PERSIST })
    @JoinTable(
            name = "notes_tags",
            joinColumns = { @JoinColumn(name = "tags_id") },
            inverseJoinColumns = { @JoinColumn(name = "notes_id") }
    )
    private Set<Tags> tags = new HashSet<>();

    public Set<Tags> getTags() {
        return tags;
    }

    public void setTags(Set<Tags> tags) {
        this.tags = tags;
    }

    public int getNotesId() {
        return notesId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
    public Note() {
    }
}
