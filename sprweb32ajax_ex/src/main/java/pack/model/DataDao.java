package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	
	@Autowired
	private JikwonRepository jikwonRepository;
	
	public List<Jikwon> jikwonnList(){
		List<Jikwon> jjlist = jikwonRepository.findAll();
		return jjlist;
	}

	// 직원 자료 읽기
	public List<Jikwon> jikwonList(String jikwonjik){
		List<Jikwon> jlist = jikwonRepository.jikwonDatas(jikwonjik);
		return jlist;
	}

}
