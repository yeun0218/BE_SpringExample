package pack.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import pack.entity.Exercise;

@Repository
public class ExerciseService {
	
	@Autowired
	private ExerciseRepository repo;
	
	//전체 자료 출력
	public List<ExerciseDto> getAllData(){
		return repo.findAll()
				.stream()
				.map(Exercise::toDto)
				.collect(Collectors.toList());
	}
	
	//자료 1개 검색
	public ExerciseDto getOneData(long id) {
		return Exercise.toDto(repo.findById(id).get());
	}
	
	//추가
	public void saveData(Exercise entity) {
		repo.save(entity);
	}
	
	//삭제
	public void delData(long id) {
		repo.deleteById(id);
	}

}
