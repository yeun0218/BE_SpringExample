package pack.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvcConfigurer : Spring MVC에 관한 설정. 
 * 웹 환경 설정용. 
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	/**
	 * 정적 리소스(이미지, CSS, JS 등) 경로 추가 설정 담당. 
	 * 업로드 경로 설정이 목표.
	 * 
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//WebMvcConfigurer.super.addResourceHandlers(registry);
		Path uploadDir = Paths.get("./uploads");
		
		// uploads 절대 경로 얻기
		String uploadPath = uploadDir.toFile().getAbsolutePath();
		
		// uploads라는 모든 URI에 접근. 
		// 예) /uploads/test.png
		// 위와 같은 URL이 들어오면 uploads 디렉토리 내에 
		// test.png를 반환한다. 
		registry.addResourceHandler("/uploads/**")
			.addResourceLocations("file:" + uploadPath + "/");
		
		// "file:" + uploadPath + "/" => 
		// 파일 시스템의 uploads 디렉토리를 나타냄. 
		// "file:" 접두사를 붙여 이 경로가 파일 시스템의 경로임을 지정한다. 
		// 해당 접두사는 WebMvcConfigurer에 대한 설정을 위함. 
	}
}
