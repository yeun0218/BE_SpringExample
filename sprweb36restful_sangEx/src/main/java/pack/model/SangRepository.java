package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SangRepository extends JpaRepository<Sang, Integer> {
	@Query("select s from Sang s where s.code = ?1")
	Sang findByCode(String code);
}
