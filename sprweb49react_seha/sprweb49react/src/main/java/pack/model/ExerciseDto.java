package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.Exercise;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseDto {
	
	private long id;
	private int duration, calorieburn;
	private String name;
	
	public static Exercise toEntity(ExerciseDto dto) {
		return Exercise.builder()
				.id(dto.getId())
				.name(dto.getName())
				.duration(dto.getDuration())
				.calorieburn(dto.getCalorieburn())
				.build();
	}

}
