package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@Getter@Table(name="sangdata")
@NoArgsConstructor
@AllArgsConstructor
public class Sang {
	@Id
	@Column(name="code")
	private int code;
	private String sang;
	
	private int su;
	private int dan;
}
