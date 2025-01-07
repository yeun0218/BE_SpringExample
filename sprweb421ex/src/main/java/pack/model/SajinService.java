package pack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.dto.SajindataDto;
import pack.entity.Sajindata;
import pack.repository.SajinRepository;

@Service
public class SajinService {
	
	@Autowired
	private SajinRepository sajinRepository;
	
	/**
	 * 모든 사진 정보를 가져온다. 
	 * 
	 * @return
	 */
	public List<SajindataDto> selectAllSajin() {
		List<Sajindata> results = sajinRepository.findAll();
		List<SajindataDto> toExport = new ArrayList<SajindataDto>();
		
		results.forEach(entity -> {
			SajindataDto dto = SajindataDto.toDto(entity);
			
			// 파일 경로 앞에 붙은 마침표(.)를 놔둔 채로 클라이언트에 전송하면 
			// 클라이언트 측에서 해당 경로를 제대로 못읽어와 이미지가 뜨지 않는다. 
			// 따라서 마침표를 제거하고 전송.
			String filePath = dto.getFilepath().replaceFirst(".", "");
			dto.setFilepath(filePath);
			
			toExport.add(dto);
		});
		
		return toExport;
	}
}
