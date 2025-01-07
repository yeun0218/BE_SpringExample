package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pack.dto.SajindataDto;
import pack.model.SajinService;

@RestController
@RequestMapping("/api")
public class SangpumRestController {

	@Autowired
	private SajinService sajinService;
	
	@GetMapping("/sangpum")
	public List<SajindataDto> responseAllInfo() {
		return sajinService.selectAllSajin();
	}
}
