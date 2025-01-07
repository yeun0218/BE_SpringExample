package pack.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JikwonDto {
	private int jikwonno;
	private String jikwonname;
	private String jikwonjik;
	private int jikwonpay;
	private String busername;
	@JsonIgnore
	private Buser buser;
	
	
	public static JikwonDto fromEntity(Jikwon jikwon) {
		return JikwonDto.builder()
				.jikwonno(jikwon.getJikwonno())
				.jikwonname(jikwon.getJikwonname())
				.jikwonjik(jikwon.getJikwonjik())
				.jikwonpay(jikwon.getJikwonpay())
				.busername(jikwon.getBuser().getBusername())
				.build();
	}
}
