package system.flight.services;

import system.flight.dto.AirlinesDTO;
import system.flight.dto.ApiResponseDTO;

import java.util.List;

public interface AirlineService {

	public ApiResponseDTO<AirlinesDTO> createAirline(AirlinesDTO dto);

	public ApiResponseDTO<List<AirlinesDTO>> getAllAirlines();

	public ApiResponseDTO<AirlinesDTO> getAirlineById(int id);

	public ApiResponseDTO<List<AirlinesDTO>> getAirlinesByName(String name);

	public ApiResponseDTO<AirlinesDTO> updateAirline(int id, AirlinesDTO dto);

	public ApiResponseDTO<Void> deleteAirline(int id);

}
