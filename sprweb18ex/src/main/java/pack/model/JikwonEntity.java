package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="jikwon")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JikwonEntity {
	@Id
	@Column(name="jikwonno")
	private int jikwonno;
	
	private String jikwonname;
	private String jikwongen;
	private String jikwonjik;
}