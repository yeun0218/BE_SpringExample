package pack.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import pack.model.DataProcess;
import pack.model.Sang;

@RestController // json을 반환할때 사용함
@RequestMapping("/api") // 아래 모든 메소드의 엔드포인트 경로에 /api를 기본경로(prefix)로 설정
public class SangController {
	
	@Autowired
	private DataProcess dataProcess;
	
	@GetMapping("/sangpums")
	public List<Sang> listProcess() { // 전체자료 읽기
		return dataProcess.getDataAll();
	}
	
	@PostMapping("/sangpums")
	public Map<String, Object> insertProcess(SangBean bean) { // 자료 추가
		//html에서 form으로 넘길 땐 @RequestBody로 받으면 안됨 ->json형식이 아니기 때문
		// @RequestBody는 json형식일때만 사용
		dataProcess.insert(bean);
		return Map.of("isSuccess", true);
	}
	@GetMapping("/sangpums/{code}")
	public Map<String, Object> getSangData(@PathVariable("code") String code) {
	    Sang sang = dataProcess.getData(code);
	    return Map.of("code", sang.getCode(), "sang", sang.getSang(), "su", sang.getSu(), "dan", sang.getDan());
	}
	@PutMapping("/sangpums")
	public Map<String, Object> updateProcess(@RequestBody SangBean bean) { // 자료 수정
		dataProcess.update(bean);
		return Map.of("isSuccess", true);
	}
	
	@DeleteMapping("/sangpums/{code}")
	public Map<String, Object> deleteProcess(@PathVariable("code")int code) { // 자료 삭제
		dataProcess.delete(code);
		return Map.of("isSuccess", true);
	}
}