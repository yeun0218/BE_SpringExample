package pack.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.Sangdata;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SangdataDto {
	private Integer code;
	private String sang;
	private Integer su;
	private Integer dan;
	
	public static SangdataDto toDto(Sangdata entity) {
		return SangdataDto.builder()
				.code(entity.getCode())
				.sang(entity.getSang())
				.su(entity.getSu())
				.dan(entity.getDan())
				.build();
	}
}
