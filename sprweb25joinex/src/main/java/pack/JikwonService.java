package pack;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JikwonService {
	@Autowired
	private JikwonRepository jikwonRepository;
	
	//직원 자료 전체 출력
	/*
	public List<JikwonDto> getAllJikwonData(){
		return jikwonRepository.findAll()
				.stream()
				.map(JikwonDto::fromEntity)
				.collect(Collectors.toList());
	}
	*/
	
	//관리 고객이 있는 직원
	public List<JikwonDto> getJikwonData(){
		return jikwonRepository.findAllWithGogekDamsano()
				.stream()
				.map(JikwonDto::fromEntity)
				.collect(Collectors.toList());
	}
	
}
