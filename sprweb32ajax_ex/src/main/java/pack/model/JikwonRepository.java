package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JikwonRepository extends JpaRepository<Jikwon, Integer> {
	@Query("select distinct j.jikwonjik from Jikwon j")
    List<String> findDistinctJikwonjik();
	
	@Query("select j from Jikwon j where j.jikwonjik= :jikwonjik")
	List<Jikwon> jikwonDatas(@Param("jikwonjik")String jikwonjik);
	
	
}
