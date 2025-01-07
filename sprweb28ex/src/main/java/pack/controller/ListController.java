package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.GogekService;
import pack.model.JikwonService;

@Controller
public class ListController {
	private GogekService gogekService;
	private JikwonService jikwonService;

	@Autowired
	public ListController(GogekService gogekService, JikwonService jikwonService) {
		this.gogekService = gogekService;
		this.jikwonService = jikwonService;
	}

	
	
	@GetMapping("jikwon")
	public String jikwonList(Model model) {
		model.addAttribute("jikwons", jikwonService.findAllWithJikwon());
		
		return "jikwon";
	}

	@GetMapping("gogek")
	public String gogekList(@RequestParam("jikwonno")  int jikwonno, Model model) {
		model.addAttribute("jikwon", jikwonService.getJikwon(jikwonno));
		model.addAttribute("gogeks", gogekService.getGogekData(jikwonno));

		return "gogek";
	}

}
