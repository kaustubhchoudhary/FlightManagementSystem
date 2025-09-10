package system.flight.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileDTO {
	private String address;
	private String phoneNo;
	private MultipartFile profileImage;
	private List<MultipartFile> iDocs;
}
