package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pack.model.Sangpum;
import pack.model.SangpumDto;
import pack.model.SangpumService;

@RestController
public class SangpumController {
	@Autowired
	private SangpumService sangpumService;
	
	@GetMapping("/products")
	public Map<String, Object> listProcess() {
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		Map<String, String> data = null;
		
		for(SangpumDto s:sangpumService.list()) {
			data = new HashMap<String, String>();
			data.put("code", String.valueOf(s.getCode()));
			data.put("sang", s.getSang());
			data.put("su", s.getSu());
			data.put("dan", s.getDan());
			list.add(data);
		}
		Map<String, Object> sangpumlist = new HashMap<String, Object>();
		sangpumlist.put("products", list);
		return sangpumlist;
	}
	
	@PostMapping("/products")
	public Map<String, Object> insertProcess(SangpumBean bean) {
		sangpumService.insert(bean);
		return Map.of("Success", true);
	}
	
	@PutMapping("/products")
	public Map<String, Object> updateProcess(@RequestBody SangpumBean bean) {
		sangpumService.update(bean);
		return Map.of("Success", true);
	}
	
	@DeleteMapping("/products/{code}")
	public Map<String, Object> deleteProcess(@PathVariable("code")int code) {
		sangpumService.delete(code);
		return Map.of("Success", true);
	}
	
	@GetMapping("/products/{code}")
	   public Sangpum update(@PathVariable("code") int code) {
	       return sangpumService.getData(code);
	}
}
