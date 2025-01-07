package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GogekController {
	private final GogekService gogekService;
	
	@Autowired
	public GogekController(GogekService gogekService) {
		this.gogekService = gogekService;
	}
	
	@GetMapping("gogek")
	public String listGogek(@RequestParam("jikwonno")int jikwonno, Model model) {
		model.addAttribute("gogeks",gogekService.getGogekData(jikwonno));
		return "gogek";
	}
}
