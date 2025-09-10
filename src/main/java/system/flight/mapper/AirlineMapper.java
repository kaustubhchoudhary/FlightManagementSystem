package system.flight.mapper;

import system.flight.dto.AirlinesDTO;
import system.flight.entities.Airline;
import system.flight.entities.User;

public class AirlineMapper {

	public static AirlinesDTO toDTO(Airline airline) {
		AirlinesDTO dto = new AirlinesDTO();
		dto.setId(airline.getAirlineId());
		dto.setName(airline.getName());
		dto.setCode(airline.getCode());
		dto.setHeadquartersCity(airline.getHeadquartersCity());
		dto.setOwnerId(airline.getOwner().getUserId());
		return dto;
	}

	public static Airline toEntity(AirlinesDTO dto, User owner) {
		Airline airline = new Airline();

		airline.setAirlineId(dto.getId());

		airline.setName(dto.getName());
		airline.setCode(dto.getCode());
		airline.setHeadquartersCity(dto.getHeadquartersCity());
		airline.setOwner(owner);

		return airline;
	}
}
