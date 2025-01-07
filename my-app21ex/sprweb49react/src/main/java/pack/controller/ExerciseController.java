package pack.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pack.model.ExerciseDto;
import pack.model.ExerciseService;

@RestController
public class ExerciseController {
	@Autowired
	private ExerciseService service;
	
	//전체자료 출력
	@GetMapping("/exercise")
	public List<ExerciseDto> getList(){
		return service.getAllData();
	}
	

	
	//자료 1개만 출력
	@GetMapping("/exercise/{id}")
	public ExerciseDto getData(@PathVariable("id")long id) {
		return service.getOneData(id);
	}
	
	//자료 입력(id제외)
	@PostMapping("/exercise")
	public Map<String,Object> insertData(@RequestBody ExerciseDto dto) {
		service.saveData(ExerciseDto.toEntity(dto));
		return Map.of("isSuccess",true);
	}
	
	//자료 삭제
	@DeleteMapping("/exercise/{id}")
	public Map<String,Object> deleteData(@PathVariable("id")long id) {
		service.delData(id);
		return Map.of("isSuccess",true);
	}
	
	//업데이트
	@PutMapping("/exercise/{id}")
	public Map<String,Object> updateData(@RequestBody ExerciseDto dto, @PathVariable("id")long id) {
		dto.setId(id);
		service.saveData(ExerciseDto.toEntity(dto));
		return Map.of("isSuccess",true);
	}
}
