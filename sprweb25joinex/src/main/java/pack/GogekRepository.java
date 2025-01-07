package pack;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GogekRepository extends JpaRepository<Gogek, Integer>{
	@Query("select g from Gogek g join g.jikwon j where j.jikwonno = :jikwonno")
	List<Gogek> findAllGogekWithJikwon(@Param("jikwonno")int jikwonno);
}
