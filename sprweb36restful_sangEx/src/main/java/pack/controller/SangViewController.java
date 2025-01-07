package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pack.model.DataProcess;
import pack.model.Sang;

@Controller
@RequestMapping("/sangpums")
public class SangViewController {
	@Autowired
	private DataProcess dataProcess;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/list")
	public String list() {
		return "list";
	}
	
//	@GetMapping("/new")
//	public String insert() {
//		return "insert";
//	}
//	
//	@GetMapping("/update/{code}")
//	public String updateProcess(@PathVariable("code")String code, Model model) {
//		Sang sang = dataProcess.getData(code);
//		model.addAttribute("data", sang);
//		return "update";
//	}
}