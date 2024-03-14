package com.sporteventssc.sporteventssc.repositories;

import com.sporteventssc.sporteventssc.entities.Participation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, String> {
}
