package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import pack.controller.SangpumBean;

@Repository
public class DataProcess {
    @Autowired
    private SangpumRepository sangpumRepository;

    /* 전체 데이터 조회 */ 
    public List<SangpumDto> getDataAll() {
        return SangpumDto.fromEntityList(sangpumRepository.findAll());
    }

    /**
     * 부분 데이터 조회 
     * @param code : PK
     * @return : 수정 창 출력용
     */
    public SangpumDto getData(int code) {
        return SangpumDto.fromEntity(sangpumRepository.findById(code).get());
    }
    
    /**
     * 데이터 추가
     * @param bean : FormBean
     * code를 입력하지 않을 경우 0으로 전달 -> 실패 메시지 반환
     *  PK 값으로 데이터를 조회 후 조회될 경우. 
     *      기본키 중복에 의한 실패 메시지 반환
     *  조회가 안 될 경우 데이터 추가 로직 수행
     */
    @Transactional
    public String insertData(SangpumBean bean) {
        // PK가 입력되지 않을 경우 return
        if (bean.getCode() <= 0) return "데이터 추가 실패 : 기본키 오류";
        try {
            sangpumRepository.findById(bean.getCode()).get();
            return "데이터 추가 실패 : 기본키 중복";
        } catch (Exception e) {
            sangpumRepository.save(SangpumBean.toEntity(bean));
            return "success";
        }
    }
    
    /**
     * 데이터 수정
     * @param bean : FormBean
     */
    @Transactional
    public String updateData(SangpumBean bean) {
        try {
            sangpumRepository.save(SangpumBean.toEntity(bean));
            return "success";
        } catch (Exception e) {
            return "데이터 수정 실패 : " + e;
        }
    }

    /**
     * 데이터 삭제
     * @param code : PK
     *  removeByCode() : Query Methods. Naming Rule에 맞게 작성
     *  
     *  CrudRepository의 deleteById()는 
     *  0이 입력되면 데이터를 삭제하지 못한다.
     */
    @Transactional
    public String deleteData(int code) {
        try {
            sangpumRepository.removeByCode(code);
            return "success";
        } catch (Exception e) {
            return "데이터 삭제 실패 : " + e;
        }
    }
}