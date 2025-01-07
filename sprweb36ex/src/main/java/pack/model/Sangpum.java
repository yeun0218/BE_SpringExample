package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "sangdata")
@NoArgsConstructor
@AllArgsConstructor
public class Sangpum {
	@Id
	private int code;
	private String sang;
	private String su;
	private String dan;
}
