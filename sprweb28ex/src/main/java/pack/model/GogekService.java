package pack.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GogekService {

	@Autowired
	private GogekRepository gogekRepository;

	public List<GogekDto> getGogekData(int jikwonno){
		return gogekRepository.findWithJikwonName(jikwonno)
				.stream()
				.map(GogekDto :: fromEntity)
				.collect(Collectors.toList());
	}
	
}
