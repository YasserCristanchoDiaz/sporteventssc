package com.sporteventssc.sporteventssc.repositories;

import com.sporteventssc.sporteventssc.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, String> {
}
