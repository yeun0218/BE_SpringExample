package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;

import pack.entity.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long>{
	
}
