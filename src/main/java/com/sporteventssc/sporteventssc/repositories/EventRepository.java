package com.sporteventssc.sporteventssc.repositories;

import com.sporteventssc.sporteventssc.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, String> {
}
