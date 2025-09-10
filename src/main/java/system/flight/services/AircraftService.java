package system.flight.services;

import java.util.List;

import system.flight.dto.AircraftResponseDTO;
import system.flight.dto.AircraftsDTO;

public interface AircraftService {

	public AircraftResponseDTO createAircraft(AircraftsDTO dto);

	public List<AircraftResponseDTO> getAllAircrafts();

	public AircraftResponseDTO getAircraftById(int id);

	public AircraftResponseDTO updateAircraft(int id, AircraftsDTO dto);

	public void deleteAircraft(int id);

}
