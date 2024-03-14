package com.sporteventssc.sporteventssc.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "participation")
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(nullable = false)
    private Integer position;

    public Participation() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
