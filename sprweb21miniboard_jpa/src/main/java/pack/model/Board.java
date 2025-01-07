package pack.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="springboard")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	@Id 
//	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 설정
	@Column(name="num")
	private int num;
	private int readcnt;
	private String author,title, content;
	
	 @Column(name="bwrite")
	 private LocalDateTime bwrite;

}
