package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDao;

@Controller
public class ListController {
	@Autowired
	private DataDao dataDao;
	
	@GetMapping(value = "jikwon")
	public String showProcess(@RequestParam("jik")String keyword, Model model) {
		if(keyword == null || keyword.isEmpty()) {
			model.addAttribute("datas", dataDao.getAllData());
		} else {
			model.addAttribute("datas", dataDao.getJikData(keyword));
			model.addAttribute("jik", keyword);
		}
		return "show";
	}
}