package system.flight.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDTO {
	private int passengerId;
	private String name;
	private int age;
	private String gender;
	private String seatNumber;
}