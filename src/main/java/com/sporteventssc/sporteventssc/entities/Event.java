package com.sporteventssc.sporteventssc.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, name = "date_event")
    private LocalDate dateEvent;

    @ManyToOne
    @JoinColumn(name = "sport_id")
    private Sport sport;

    @OneToMany(mappedBy = "event")
    @JsonIgnore
    private List<Participation> participations;

    public Event() {
        participations = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(LocalDate dateEvent) {
        this.dateEvent = dateEvent;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public List<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }
}
