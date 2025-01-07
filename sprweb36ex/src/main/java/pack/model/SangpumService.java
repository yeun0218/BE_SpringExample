package pack.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.SangpumBean;

@Repository
public class SangpumService {
	@Autowired
	private SangpumRepository sangpumRepository;
	
	// 읽기
	public List<SangpumDto> list() {
		List<SangpumDto> list = sangpumRepository.findAll()
				.stream()
				.map(SangpumDto :: todto)
				.collect(Collectors.toList());
		return list;
	}
	
	// 추가
	public String insert(SangpumBean bean) {
		try {
			Sangpum sangpum = sangpumRepository.findById(bean.getCode()).get();
			return "이미 등록된 번호입니다.";
		} catch (Exception e) {
			// findById의 결과가 에러인 경우(등록 가능한 번호)
			try {
				Sangpum sangpum = new Sangpum(bean.getCode(), bean.getSang(), bean.getSu(), bean.getDan());
				sangpumRepository.save(sangpum);
				return "success";
			} catch (Exception e2) {
				return "입력 자료 오류 : " + e2.getMessage();
			}
		}
	}
	
	// 수정 레코드 읽기
	public Sangpum getData(int code) {
		Sangpum sangpum = sangpumRepository.findByCode(code);
		return sangpum;
	}
	
	
	// 수정
	public String update(SangpumBean bean) {
		try {
			Sangpum sangpum = new Sangpum(bean.getCode(), bean.getSang(), bean.getSu(), bean.getDan());
			sangpumRepository.save(sangpum);
			return "success";
		} catch (Exception e) {
			return "수정 작업 오류 : " + e.getMessage();
		}
	}
	
	// 삭제
	public String delete(int code) {
		try {
			sangpumRepository.deleteById(code);
			return "success";
		} catch (Exception e) {
			return "삭제 작업 오류 : " + e.getMessage();
		}
	}
}
