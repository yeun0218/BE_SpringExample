package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuserDto {
	
	private int buserno;
	private String busername;
	private String busertel;
	private String buserloc;
	
	
	//2. builder어노테이션 사용
	public static BuserDto fromEntity(Buser entity) {
		return BuserDto.builder()
				.buserno(entity.getBuserno())
				.busername(entity.getBusername())
				.busertel(entity.getBusertel())
				.build();
				
	}
}
