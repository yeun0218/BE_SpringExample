package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import pack.model.DataDao;
import pack.model.Jikwon;
import pack.model.JikwonRepository;

@Controller
public class DataController {
	@Autowired
	private DataDao dataDao;
	
	@Autowired
	private JikwonRepository jikwonRepository;
	
	
	
	@GetMapping("jjikwonlist") // 타임리프 사용
	public String JikwonProcess(Model model) {
	    List<Jikwon> jlist = dataDao.jikwonnList();
	    
	    // 중복 직급 제거
	    Set<String> uniqueJikgwon = new HashSet<>();
	    List<Jikwon> filteredJlist = new ArrayList<>();
	    
	    for (Jikwon j : jlist) {
	        if (uniqueJikgwon.add(j.getJikwonjik())) { // 중복되지 않는 경우만 추가
	            filteredJlist.add(j);
	        }
	    }
	    
	    model.addAttribute("jlist", filteredJlist);
	    return "list"; // 'list'는 Thymeleaf 템플릿의 이름입니다.
	}

	
	
	@GetMapping("jikwonlist")
	@ResponseBody
	public Map<String, Object> jikwonProcess(@RequestParam("jikwonjik")String jikwonjik) {
		List<Map<String, String>> jlist = new ArrayList<Map<String,String>>();
		Map<String, String> data = null;
		
		for(Jikwon j:dataDao.jikwonList(jikwonjik)) {
			data = new HashMap<String, String>();
			data.put("jikwonno", String.valueOf(j.getJikwonno()));
			data.put("jikwonname",j.getJikwonname());
			data.put("jikwonjik", j.getJikwonjik());
			data.put("jikwonpay", String.valueOf(j.getJikwonpay()));
			data.put("jikwonrating", j.getJikwonrating());
			jlist.add(data);
		}
		
		Map<String, Object> jiklist = new HashMap<String, Object>();
		jiklist.put("datas", jlist);
		return jiklist;
	}
}