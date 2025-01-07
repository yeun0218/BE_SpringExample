package pack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.DataDAO;
import pack.model.JikwonEntity;

@Controller
public class MainController {
	@Autowired
	private DataDAO dataDAO;
	
	@GetMapping("/")
	public String goIndex() {
		return "index";
	}
	
	//전체 자료 검색
	@GetMapping("testdb")
	public String listProcess(Model model) {
		return "list";
	}
		
	//검색어 입력
	@PostMapping("search")
	public String searchProcess(Model model, FormBean bean) {
		List<JikwonEntity> list = (ArrayList<JikwonEntity>) dataDAO.getDataSearch(bean.getSearchValue(), bean.getJikwongen());
		
		model.addAttribute("datas", list);
		
		return "show";
	}
}