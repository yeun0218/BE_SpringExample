package pack.contoroller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.DataDao;
import pack.model.JikwonDto;

@Controller
public class ProcessController {
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("jikwon") // index에 지정한 경로 작성
	public String showProcess(Model model) {
		ArrayList<JikwonDto> list = (ArrayList<JikwonDto>)dataDao.getDataAll(); 
		model.addAttribute("datas", list);
		return "show"; // show.html
	}
	
	@GetMapping("search")
	public String searchProcess(Model model, FormBean bean) {
		ArrayList<JikwonDto> list = (ArrayList<JikwonDto>)dataDao.getDataSearch(bean); 
		model.addAttribute("datas", list);
		return "show"; // show.html
	}
	
	
}
