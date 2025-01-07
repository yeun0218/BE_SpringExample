package pack.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JikwonService {
		
		@Autowired
	    private JikwonRepository jikwonRepository;

	    public List<JikwonDto> findAllWithJikwon() {
	        return jikwonRepository.findAll().stream()
	                .map(JikwonDto::fromEntity)  // 엔터티를 DTO로 변환
	                .collect(Collectors.toList());
	    }
	    
	    
	    public JikwonDto getJikwon(int jikwonno) {
	    	Jikwon jikwon = jikwonRepository.findById(jikwonno).get();
	    	return JikwonDto.builder()
	    			.jikwonjik(jikwon.getJikwonjik())
	    			.jikwonname(jikwon.getJikwonname())
	    			.build();
	    }
}
