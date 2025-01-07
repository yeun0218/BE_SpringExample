package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pack.model.JikwonDto;
import pack.model.JikwonProcess;


@RestController
public class ListController {
	@Autowired
	private JikwonProcess jikwonProcess;

	
	@GetMapping("list")
	public List<JikwonDto> Jiklist(JikwonDto jikwonDto ) {
		
		return jikwonProcess.getAllJik();
				
	}
}
