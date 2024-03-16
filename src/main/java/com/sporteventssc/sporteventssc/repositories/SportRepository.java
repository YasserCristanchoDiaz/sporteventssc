package com.sporteventssc.sporteventssc.repositories;

import com.sporteventssc.sporteventssc.entities.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportRepository extends JpaRepository<Sport, Integer> {
}
