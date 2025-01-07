package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JikwonRepository extends JpaRepository<JikwonEntity, Integer> {
	//직급만
	List<JikwonEntity> findByJikwonjikContaining(String sValue);
	
	//성별만
	List<JikwonEntity> findByJikwongen(String jikwongen);
	
	//직급, 성별
	List<JikwonEntity> findByJikwonjikContainingAndJikwongen(String sValue, String jikwongen);
}