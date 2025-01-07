package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JikwonDto {
	private int jikwonno;
	private String jikwonjik,jikwonname,jikwonpay,jikwonrating;
	
	// entity -> dto
	public static JikwonDto toDto(Jikwon jikwon) {
		return JikwonDto.builder()
				.jikwonno(jikwon.getJikwonno())
				.jikwonjik(jikwon.getJikwonjik())
				.jikwonname(jikwon.getJikwonpay())
				.jikwonpay(jikwon.getJikwonpay())
				.jikwonrating(jikwon.getJikwonrating())
				.build();
	}
}
