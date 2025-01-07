package pack.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.dto.SajindataDto;

@Entity
@Table(name = "sajindata")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sajindata {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String about;
	
	@Column(updatable = false)
	private LocalDateTime uploadat;
	
	@Column(length = 255)
	private String filepath;
	
	@PrePersist
	private void initUploadDate() {
		uploadat = LocalDateTime.now();
	}
	
	@OneToOne
	@JoinColumn(name = "sangcode")
	private Sangdata sangdata;
	
	public static Sajindata toEntity(SajindataDto dto) {
		
		return Sajindata.builder()
				.id(dto.getId())
				.about(dto.getAbout())
				.filepath(dto.getFilepath())
				.sangdata(Sangdata.toEntity(dto.getSangdataDto()))
				.build();
	}
}
