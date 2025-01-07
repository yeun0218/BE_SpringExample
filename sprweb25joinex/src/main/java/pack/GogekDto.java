package pack;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GogekDto {
	private int gogekno;
	private String gogekname;
	private String gogektel;
	private JikwonDto jikwonDto;
	
	public Gogek toEntity() {
		Gogek gogek = new Gogek();
		gogek.setGogekno(this.gogekno);
		gogek.setGogekname(this.gogekname);
		gogek.setGogektel(this.gogektel);
		if(this.jikwonDto != null) {
			gogek.setJikwon(this.jikwonDto.toEntity());
		}
		return gogek;
	}
	
	public static GogekDto fromEntity(Gogek gogek) {
		GogekDto dto = new GogekDto();
		dto.setGogekno(gogek.getGogekno());
		dto.setGogekname(gogek.getGogekname());
		dto.setGogektel(gogek.getGogektel());
		if(gogek.getJikwon() != null) {
			dto.setJikwonDto(JikwonDto.fromEntity(gogek.getJikwon()));
		}
		return dto;
	}
}
