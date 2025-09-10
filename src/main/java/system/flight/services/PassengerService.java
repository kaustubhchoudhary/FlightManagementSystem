package system.flight.services;

import system.flight.dto.PassengerInfoDTO;
import system.flight.services.PassengerService;

import java.util.List;

public interface PassengerService {

	public List<PassengerInfoDTO> getAllPassengers();

	public PassengerInfoDTO getPassengerById(int id);

	public void deletePassenger(int id);
}