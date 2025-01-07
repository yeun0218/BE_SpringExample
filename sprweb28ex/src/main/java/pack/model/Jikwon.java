package pack.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="jikwon")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Jikwon {
	@Id 
	private int jikwonno;
	private String jikwonname;
	private String jikwonjik;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="busernum")
	private Buser buser;
	
	@OneToMany(mappedBy = "jikwon" , fetch= FetchType.LAZY)
	private List<Gogek> gogekList;
}
