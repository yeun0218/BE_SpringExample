package pack;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public class GogekService {
	@Autowired
	private GogekRepository gogekRepository;
	
	public List<GogekDto> getGogekData(int jikwonno){
		return gogekRepository.findAllGogekWithJikwon(jikwonno)
				.stream()
				.map(GogekDto::fromEntity)
				.collect(Collectors.toList());
	} 
}
