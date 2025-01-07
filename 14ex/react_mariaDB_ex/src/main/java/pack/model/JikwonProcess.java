package pack.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JikwonProcess {
	@Autowired
	private JikwonRepository jikwonRepository;
	
	public List<JikwonDto> getAllJik(){
		List<Jikwon> list = jikwonRepository.findAll();
		return list.stream().map(JikwonDto :: fromEntity).collect(Collectors.toList());
	}

}
