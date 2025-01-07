package pack.model;

import java.util.List;
import java.util.stream.Collectors;

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
public class JikwonDto {
	private int jikwonno;
	private String jikwonname;
	private String jikwonjik;
	private BuserDto buserDto;
	private List<GogekDto> gogekList; // 관리 고객 리스트
	
	 public static JikwonDto fromEntity(Jikwon jikwon) {
	        BuserDto buserDto = null;
	        if (jikwon.getBuser() != null) {
	            buserDto = BuserDto.fromEntity(jikwon.getBuser());
	        }

	        List<GogekDto> gogekList = jikwon.getGogekList().stream()
	                .map(GogekDto::fromEntity)
	                .collect(Collectors.toList());

	        return JikwonDto.builder()
	                .jikwonno(jikwon.getJikwonno())
	                .jikwonname(jikwon.getJikwonname())
	                .jikwonjik(jikwon.getJikwonjik())
	                .buserDto(buserDto) 
	                .gogekList(gogekList) // 관리 고객 리스트 포함
	                .build();
	    }

}