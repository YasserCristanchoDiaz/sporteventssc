package com.sporteventssc.sporteventssc.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "participant")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(nullable = false, length = 32)
    private String name;

    @Column(nullable = false, length = 32, name = "last_name")
    private String lastName;

    @Column(nullable = false, length = 1)
    private String gender;

    @Column(nullable = false)
    private String mail;

    @Column(nullable = false)
    private Integer phone;

    @Column(nullable = false)
    private LocalDate birthday;

    @OneToMany(mappedBy = "participant")
    private List<Participation> participations;

    public Participant() {
        participations = new ArrayList<>();
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public List<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }
}
