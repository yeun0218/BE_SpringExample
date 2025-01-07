package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SangDto {
	private int code;
	private String sang;
	
	private int su;
	private int dan;
	
	public static SangDto fromEntity(Sang sang) {
		return SangDto.builder()
				.code(sang.getCode())
				.sang(sang.getSang())
				.su(sang.getSu())
				.dan(sang.getDan())
				.build();
	}
}
