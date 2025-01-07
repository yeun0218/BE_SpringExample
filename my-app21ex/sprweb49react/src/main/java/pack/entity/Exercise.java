package pack.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pack.model.ExerciseDto;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; //DB bigint와 매칭
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private int duration, calorieburn;
	
	public static ExerciseDto toDto(Exercise entity) {
		return ExerciseDto.builder()
				.id(entity.getId())
				.name(entity.getName())
				.duration(entity.getDuration())
				.calorieburn(entity.getCalorieburn())
				.build();
	}
}
