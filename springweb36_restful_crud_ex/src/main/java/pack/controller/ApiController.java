package pack.controller;

import java.util.List;
import java.util.Map;
import pack.model.DataProcess;
import pack.model.SangpumDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value="/api")
public class ApiController {
    @Autowired
    private DataProcess dataProcess;

    // 상품 목록 조회
    @GetMapping("/sang")
    public List<SangpumDto> selectData() {
        return dataProcess.getDataAll();
    }
    
    /**
     * 상품 자료 추가
     * @RequestBody -> JSON형식 데이터 수신
     * @param bean : 추가할 데이터 FormBean의 형태로 전달
     * @return : 성공 여부 반환
     */
    @PostMapping("/sang")
    public Map<String, Object> insertData(@RequestBody SangpumBean bean) {
        return resultData(dataProcess.insertData(bean));
    }

    /**
     * 상품 자료 수정 창 출력 데이터
     * @param code : 경로 변수로 PK 수신, 데이터 조회
     * @return DTO : 수정 창에 출력할 데이터 전송용 객체
     */
    @GetMapping("/sang/{code}")
    public SangpumDto selectDataForUpdate(@PathVariable(value="code") int code) {
        return dataProcess.getData(code);
    }
    
    /**
     * 상품 자료 수정
     * @RequestBody -> JSON형식 데이터 수신
     * @param bean : FormBean 
     * @return : 성공 여부 반환
     */
    @PutMapping("/sang")
    public Map<String, Object> updateData(@RequestBody SangpumBean bean) {
        return resultData(dataProcess.updateData(bean));
    }

    /**
     * 상품 자료 삭제
     * @param code : PK
     * @return : 성공 여부 반환
     */
    @DeleteMapping("/sang/{code}")
    public Map<String, Object> deleteData(@PathVariable(value="code") int code) {
        return resultData(dataProcess.deleteData(code));
    }

    /**
     * 로직 처리 후 출력 메시지 반환 메서드
     * @param result : DAO에서 처리한 결과를 담은 문자열
     * @return : 성공 여부에 따른 메시지 저장 자료 구조
     */
    private Map<String, Object> resultData(String result) {
        if (result.equals("success")) {
            // 성공 시 성공 메시지 반환 -> JS에서 처리 "목록 보기"
            return Map.of("isSuccess", true);
        }
        // 실패 시 오류 메시지 반환
        return Map.of("error", result);
    }
}