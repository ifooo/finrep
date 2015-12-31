package com.asseco.see.mk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asseco.see.mk.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
