package system.flight.services;

import java.util.List;

import system.flight.dto.*;
import system.flight.entities.*;

public interface BookingService {

	public Seat getSeatByName(String seatName, int aircraftId);

	public BookingResponseDTO createBooking(BookingRequestDTO dto);

	public List<BookingResponseDTO> getAllBookings();

	public BookingResponseDTO getBookingById(int id);

	public BookingResponseDTO updateBooking(int bookingId, BookingUpdateDTO dto);

	public void deleteBooking(int id);
}