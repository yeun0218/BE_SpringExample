package pack;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JikwonRepository extends JpaRepository<Jikwon, Integer>{
	@Query("select distinct j from Jikwon j join j.gogekList g where g is not null")
	List<Jikwon> findAllWithGogekDamsano();
}
