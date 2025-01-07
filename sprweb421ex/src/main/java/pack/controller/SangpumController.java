package pack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pack.model.FileService;

@Controller
@RequestMapping("/main")
public class SangpumController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private FileService fileService;

	@Value("${file.upload-dir}")
	private String uploadDir;

	@GetMapping("")
	public String toIndex() {
		return "index";
	}

	@GetMapping("/upload")
	public String toUpload() {
		return "upload";
	}

	@PostMapping("/upload")
	public String uploadProcess(UploadRequest uploadRequest) {
		fileService.saveAllData(uploadRequest);
		return "redirect:/";
	}
	
	@GetMapping("/sangpum")
	public String toSangpumList() {
		return "sangpums";
	}
}
