package pack.controller;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

/**
 * Form bean
 */
@Getter
@Setter
public class UploadRequest {
	private String sang;
	private Integer su;
	private Integer dan;
	private String about;
	private String filePath;
	
	private MultipartFile file;
}
