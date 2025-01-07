package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDAO {
	@Autowired
	private JikwonRepository repository;
	
	//전체 직원 조회
	public List<JikwonEntity> getDataAll() {
		List<JikwonEntity> list = repository.findAll();
		
		return list;
	}
	
	//직급 검색용
   public List<JikwonEntity> getDataSearch(String sValue, String jikwongen) {
       List<JikwonEntity> slist;

       // 성별에 따른 검색 조건 설정
       if (jikwongen != null && !jikwongen.isEmpty() && sValue != null && !sValue.isEmpty()) {
           slist = repository.findByJikwonjikContainingAndJikwongen(sValue, jikwongen); // 두 조건으로 필터링
       } else if (sValue != null && !sValue.isEmpty()) {
           slist = repository.findByJikwonjikContaining(sValue); // 직급만 검색
       } else if (jikwongen != null && !jikwongen.isEmpty()) {
           slist = repository.findByJikwongen(jikwongen); // 성별만 검색
       } else {
           slist = repository.findAll(); // 둘 다 비어있으면 전체 반환
       }

       System.out.println("검색값: " + sValue + ", 성별: " + jikwongen + ", 결과: " + slist.size() + "개");
       
       return slist;
   }
}