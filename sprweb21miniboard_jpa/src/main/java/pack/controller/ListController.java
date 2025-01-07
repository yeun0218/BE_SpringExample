package pack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.Board;
import pack.model.BoardProcess;

@Controller
public class ListController { 
	@Autowired
	private BoardProcess boardProcess;
	
	@GetMapping("/")
	public String gogo() {
		return "index";
	}
	// 리스트 페이지 이동
	@GetMapping("list")
	public String list (Model model){
		ArrayList<Board> list = (ArrayList<Board>)boardProcess.getDataAll();
		model.addAttribute("datas", list);
		return "list";
	}
	// 등록 페이지 이동
	@GetMapping("insert")
	public String insert() {
		return "insform";
	}

	// 등록 Process
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public String insertProcess(BoardBean bean, Model model) {
		String msg = boardProcess.insert(bean);
		
		if(msg.equals("success")) {
			return"redirect:list"; // 추가 후 목록보기로 이동
		}else {
			model.addAttribute("msg", msg);
			return"forward:error";
		}
	}
	
	// 수정 페이지 이동
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String update(@RequestParam("num") int num, Model model) {
	    // 게시글 조회 및 조회수 증가
	    boardProcess.updateCnt(num); // 조회수 증가 메서드 호출
	    Board board = boardProcess.getData(num);
	    
	    model.addAttribute("data", board);
	    return "detail";
	}
	
	// 수정 Process
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String updateProcess(BoardBean bean, Model model) {
		String msg = boardProcess.update(bean);
		if(msg.equals("success")) {
			return"redirect:list"; // 추가 후 목록보기로 이동
		}else {
			model.addAttribute("msg", msg);
			return"forward:error";
		}
	}
	// 삭제 Process
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String deleteProcess(@RequestParam("num")int num, Model model) {
		String msg = boardProcess.delete(num);
		if(msg.equals("success")) {
			return"redirect:list"; // 추가 후 목록보기로 이동
		}else {
			model.addAttribute("msg", msg);
			return"forward:error";
		}
	}
	
	// 검색 기능
	@RequestMapping(value="search", method=RequestMethod.POST)
	public String searchProcess(@RequestParam("searchField") String searchField, 
	                            @RequestParam("searchValue") String searchValue, 
	                            Model model) {
	    List<Board> list = boardProcess.getDataSearch(searchValue, searchValue);
	
	    model.addAttribute("datas", list);
	    return "list";
	}
}
