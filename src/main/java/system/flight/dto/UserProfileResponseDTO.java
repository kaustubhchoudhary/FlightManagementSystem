package system.flight.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileResponseDTO {
	private String address;
	private String phoneNo;
	private String profileImage;
	private List<String> idDocs;
}
