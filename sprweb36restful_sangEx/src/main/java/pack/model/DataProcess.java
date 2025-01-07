package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.SangBean;

@Repository
public class DataProcess {
	@Autowired
	private SangRepository repository; // hikari pool 자동 지원
	
	// 전체 자료
	public List<Sang> getDataAll(){
		List<Sang> list = repository.findAll();
		
		return list;
	}
	
	// 추가
	public String insert(SangBean bean) {
		
		// 입력한 번호 중복 확인(실습)
		try {
			Sang sang = repository.findById(bean.getCode()).get();
			return "이미 등록된 번호입니다";
		} catch (Exception e) {
			// findById의 결과가 error인 경우(등록 가능한 번호)
			try {
				Sang sang = new Sang(bean.getCode(),bean.getSang(), bean.getSu(), bean.getDan());
				repository.save(sang);
				return "success";
			} catch (Exception e2) {
				return "입력 자료 오류 : " + e2.getMessage();
			}
		}
	}
	
	// 수정 & 삭제를 위한 레코드 읽기
	public Sang getData(String code) {
		Sang sang = repository.findByCode(code);
		return sang;
	}
	
	// 수정
	public String update(SangBean bean) {
		try {
			Sang sang = new Sang(bean.getCode(),bean.getSang(), bean.getSu(), bean.getDan());
			repository.save(sang);
			return"success";
		} catch (Exception e) {
			return "수정 자료 오류 : " + e.getMessage();
		}
	}
	
	// 삭제
	public String delete(int code) {
		try {
			repository.deleteById(code);
			return"success";
		} catch (Exception e) {
			return "삭제 작업 오류 : " + e.getMessage();
		}
	}
}