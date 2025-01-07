package pack.model;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import pack.controller.UploadRequest;
import pack.dto.SajindataDto;
import pack.dto.SangdataDto;
import pack.entity.Sajindata;
import pack.entity.Sangdata;
import pack.repository.SajinRepository;
import pack.repository.SangdataRepository;

@Service
public class FileService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value("${file.upload-dir}")
	private String uploadDir;
	
	@Autowired
	private SangdataRepository sangdataRepository;
	
	@Autowired
	private SajinRepository sajinRepository;
	
	/**
	 * 메인 로직
	 * 
	 * @param uploadRequest
	 * @return - 데이터 삽입 성공 시 true, 실패 시 false
	 */
	public boolean saveAllData(UploadRequest uploadRequest) {
		Path filePath = determineFilePath(uploadRequest);
		if (filePath == null) {
			throw new RuntimeException("[saveAllData] 파일 경로 조회 불가.");
		}
		
		try {
			uploadRequest.setFilePath(filePath.toString());
			SajindataDto requestDto = extractSajinDto(uploadRequest);
			
			saveSangdata(requestDto);
			saveSajin(requestDto);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * 사용자 요청으로부터 주어진 정보들을 토대로 파일 경로를 결정하여 저장한다.
	 * 
	 * @param uploadRequest
	 * @return - 최종 결정된 파일경로
	 */
	private Path determineFilePath(UploadRequest uploadRequest) {
		Path filePath = null;
		
		try {
			MultipartFile file = uploadRequest.getFile();
			// 서버에 똑같은 파일명이 있을 경우
			// (현재시간)aaa.png, (현재시간)aaa.png와 같이 구분하여 파일명이 고유해지도록 한다.
			String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

			Path uploadPath = Paths.get(uploadDir);
			System.out.println("current upload path : " + uploadPath);

			if (Files.notExists(uploadPath)) {
				// 업로드 디렉토리 비존재 시 새로 생성.
				Files.createDirectories(uploadPath);
			}

			// resolve : fileName을 결합하여 최종 파일경로를 생성하는 메서드.
			filePath = uploadPath.resolve(fileName);

			// 파일을 특정 경로로 복사 하기.
			// 이미 동일 파일 존재 시 덮어쓰기
			// Files.copy() : InputStream으로부터 파일을 읽어 filePath 위치에
			// 파일을 저장함.
			// StandardCopyOption.REPLACE_EXISTING : 덮어쓰기 옵션
			Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
			
		} catch (Exception e) {
			logger.error("[uploadProcess] 에러 발생 : " + e.getMessage());
			e.printStackTrace();
		}
		
		return filePath;
	}
	
	public SajindataDto saveSajin(SajindataDto requestDto) {
		Sajindata sajinEntity = Sajindata.toEntity(requestDto);
		Sajindata savedResult = sajinRepository.save(sajinEntity);
		
		return SajindataDto.toDto(savedResult);
	}
	
	public SangdataDto saveSangdata(SajindataDto requestDto) {
		Sangdata sangEntity = Sangdata.toEntity(requestDto.getSangdataDto());
		Sangdata savedResult = sangdataRepository.save(sangEntity);
		return SangdataDto.toDto(savedResult);
	}
	
	/**
	 * 사용자 요청 정보를 담은 UploadRequest 객체로부터 정보를 추출하여 
	 * 각각 SajindataDto, SangdataDto로 변환
	 * 
	 * @param uploadRequest
	 * @return - SangdataDto는 SajindataDto에 담긴 채 반환된다. 
	 */
	private SajindataDto extractSajinDto(UploadRequest uploadRequest) {
		Integer maxCode = sangdataRepository.findByCodeMax() + 1;
		Integer maxCodeSajin = sajinRepository.findByCodeMax();
		if (maxCodeSajin == null) {
			maxCodeSajin = 1;
		}
		
		SangdataDto sangDto = SangdataDto.builder()
				.code(maxCode)
				.sang(uploadRequest.getSang())
				.su(uploadRequest.getSu())
				.dan(uploadRequest.getDan())
				.build();
		
		SajindataDto sajinDto = SajindataDto.builder()
				.id(maxCodeSajin + 1)
				.about(uploadRequest.getAbout())
				.filepath(uploadRequest.getFilePath())
				.sangdataDto(sangDto)
				.build();
		
		return sajinDto;
	}
	
}
