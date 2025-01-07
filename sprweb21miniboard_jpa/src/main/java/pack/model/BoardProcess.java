package pack.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pack.controller.BoardBean;

@Service // 서비스 클래스이므로 @Service 어노테이션 사용
public class BoardProcess {

    @Autowired
    private BoardRepository repository;
    
    // 전체 자료 읽기
    public List<Board> getDataAll() {
        // repository의 다양한 기능을 사용할 수 있다.
        List<Board> list = repository.findAll(); // 기본 제공 메소드
        System.out.println("list : " + list.size() + "개");
        
        return list;
    }

    //추가
    @Transactional  // 나이스~~~
    public String insert(BoardBean bean) {
        Integer maxNum = repository.findMaxNum();
        int newNum = (maxNum == null) ? 1 : maxNum + 1; // maxNum이 null일 경우 1로 설정
        
        Board board = new Board(newNum, bean.getReadcnt(), bean.getAuthor(), 
                                bean.getTitle(), bean.getContent(), LocalDateTime.now());
        repository.save(board);
        return "success";
    }

    
	 // 수정 & 삭제를 위한 레코드 읽긴
    public Board getData(int num) {
        return repository.findByNum(num); 
    }
    
	// 수정
    @Transactional
    public String update(BoardBean bean) {
        // 게시글 ID로 기존 게시글을 조회
        Board existingBoard = repository.findByNum(bean.getNum());

        // 수정된 게시글 정보를 새로운 Board 객체로 생성
        Board board = new Board(bean.getNum(), existingBoard.getReadcnt(), bean.getAuthor(), 
                                 bean.getTitle(), bean.getContent(), LocalDateTime.now());
        
        // 수정된 게시글 저장
        repository.save(board);
        
        return "success";
    }

	
	// 삭제
    @Transactional
	public String delete(int num) {
			repository.deleteById(num);
			return"success";
	}
    
    // 조회수 업데이트
    @Transactional
    public int updateCnt(int num) {
        return repository.updateCnt(num);
    }
    
   // 검색 기능
   public List<Board> getDataSearch(String author, String title) {
	    List<Board> blist;

	     if (author != null && !author.isEmpty()) {
	    	 blist = repository.findByauthorContaining(author); 
	    } else if (title != null && !title.isEmpty()) {
	    	blist = repository.findBytitle(title); 
	    } else {
	    	blist = repository.findAll(); // 둘 다 비어있으면 전체 반환
	    }
	    return blist;
	}
}
