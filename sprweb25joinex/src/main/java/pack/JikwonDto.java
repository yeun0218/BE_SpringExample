package pack;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JikwonDto {
	private int jikwonno;
	private String jikwonname;
	private String jikwonjik;
	
	public Jikwon toEntity() {
		Jikwon jikwon = new Jikwon();
		jikwon.setJikwonno(this.jikwonno);
		jikwon.setJikwonname(this.jikwonname);
		jikwon.setJikwonjik(this.jikwonjik);
		return jikwon;
	}
	
	public static JikwonDto fromEntity(Jikwon jikwon) {
		JikwonDto dto = new JikwonDto();
		dto.setJikwonno(jikwon.getJikwonno());
		dto.setJikwonname(jikwon.getJikwonname());
		dto.setJikwonjik(jikwon.getJikwonjik());
		return dto;
	}
}
