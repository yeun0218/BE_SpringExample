package pack.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pack.dto.SangdataDto;

@Entity
@Table(name = "sangdata")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sangdata {
	@Id
	private Integer code;
	
	@Column(length = 20)
	private String sang;
	
	@Column(length = 11)
	private Integer su;
	
	@Column(length = 11)
	private Integer dan;
	
	@OneToOne(mappedBy = "sangdata")
	private Sajindata sajinData;
	
	public static Sangdata toEntity(SangdataDto dto) {
		return Sangdata.builder()
				.code(dto.getCode())
				.sang(dto.getSang())
				.su(dto.getSu())
				.dan(dto.getDan())
				.build();
	}
}
