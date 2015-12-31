package com.asseco.see.mk.service;

import java.util.List;

import com.asseco.see.mk.model.Reservation;

public interface IReservationService {
	void saveReservation(Reservation reservation);
	
	List<Reservation> getReservations();

}
