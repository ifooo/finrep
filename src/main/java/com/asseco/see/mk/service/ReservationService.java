package com.asseco.see.mk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asseco.see.mk.model.Reservation;
import com.asseco.see.mk.repository.ReservationRepository;

@Service
@Transactional
public class ReservationService implements IReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	public void saveReservation(Reservation reservation) {

		reservationRepository.save(reservation);
	}

	public List<Reservation> getReservations() {
		return reservationRepository.findAll();
	}

}
