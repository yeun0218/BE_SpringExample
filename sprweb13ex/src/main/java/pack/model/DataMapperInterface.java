package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataMapperInterface {

	@Select("SELECT j.jikwonno, j.jikwonname, j.jikwonjik, b.busername, j.jikwonpay FROM jikwon j JOIN buser b WHERE j.busernum = b.buserno")
	List<JikwonDto> selectAll();
	
	// 컬럼 명은 써주는것이 좋다! 
	@Select("SELECT j.jikwonno, j.jikwonname, j.jikwonjik, b.busername, j.jikwonpay FROM jikwon j JOIN buser b WHERE j.busernum = b.buserno AND jikwonname LIKE concat('%',#{searchValue},'%')")
	List<JikwonDto> selectSearch(String searchValue); // 직원명 검색


}
