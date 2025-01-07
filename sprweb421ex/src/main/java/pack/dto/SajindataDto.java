package pack.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.Sajindata;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SajindataDto {
	private Integer id;
	private String about;
	private LocalDateTime uploadat;
	private String filepath;
	
	private SangdataDto sangdataDto;
	
	public static SajindataDto toDto(Sajindata entity) {
		return SajindataDto.builder()
				.id(entity.getId())
				.about(entity.getAbout())
				.uploadat(entity.getUploadat())
				.filepath(entity.getFilepath())
				.sangdataDto(SangdataDto.toDto(entity.getSangdata()))
				.build();
	}
}
