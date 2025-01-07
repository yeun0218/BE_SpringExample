package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface BoardRepository extends JpaRepository<Board, Integer> {

    // 검색
	List<Board> findByauthorContaining(String author);
	List<Board> findBytitle(String title);

    // 조회수 업데이트 메서드
	@Modifying // JPA가 데이터베이스의 상태를 변경하는 쿼리임을 인식
	// 1차 캐시를 비워주는 설정을 부여.
	// 벌크 연산(대량의 데이터를 한번에 수정,삭제하는 방법)을 함.
	// 벌크 연산은 영속성 컨텍스트를 무시하고 DB에 직접 쿼리한다는 점에 주의!!!
	// 그래서 영속성 컨텍스트에 있는 자료와 DB에 있는 자료가 다를 수 있다. 
	// 그러므로 영속성 컨텍스트에 있는 쿼리를 flush하거나 clear 해야 한다.
	@Query(value = "update Board b set b.readcnt = b.readcnt + 1 where b.num = :num")
    int updateCnt(@Param("num")int num);
		
    // num 자동 증가 처리를 위한 코드
	@Query(value = "select max(b.num) from Board b")
	int findMaxNum();
	
//	@Query(value="select b from Board as b where b.num=?1")
//	Board findBynum(String num);
	
	Board findByNum(int num);
}
