package com.sporteventssc.sporteventssc.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sport")
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeMode typeMode;

    @OneToMany(mappedBy = "sport")
    private List<Event> events;

    public Sport() {
        events = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeMode getTypeMode() {
        return typeMode;
    }

    public void setTypeMode(TypeMode typeMode) {
        this.typeMode = typeMode;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
