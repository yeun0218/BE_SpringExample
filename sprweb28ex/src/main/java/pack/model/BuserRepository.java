package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BuserRepository extends JpaRepository<Buser, Integer>{

	@Query("SELECT b FROM Buser b LEFT JOIN b.jikwonList j")
	List<Buser> findAllBuserWithJikwon();
}
