package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Jikwon {
	@Id
	private int jikwonno;
	
	private String jikwonname, jikwonjik, jikwonpay, jikwonrating;
	

}
