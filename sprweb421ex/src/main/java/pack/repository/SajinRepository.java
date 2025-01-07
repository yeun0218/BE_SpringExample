package pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pack.entity.Sajindata;

public interface SajinRepository extends JpaRepository<Sajindata, Integer> {
	
	/**
	 * AUTO_INCREMENT를 구현하기 위해 현재 DB로부터 가장 높은 id값을 가져온다. 
	 * 
	 * @return
	 */
	@Query("SELECT MAX(s.id) FROM Sajindata s")
	Integer findByCodeMax();
}
