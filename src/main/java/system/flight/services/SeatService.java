package system.flight.services;

import system.flight.entities.Seat;

public interface SeatService {

	public Seat getSeatByName(String seatName, int aircraftId);

	public boolean isSeatBooked(String seatName, int aircraftId);

	public void markSeatAsBooked(String seatName, int aircraftId);

	public void markSeatAsAvailable(String seatName, int aircraftId);

}