package pack.model;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SangpumDto {
    private int code, su, dan;
    private String sang;
    
    public static SangpumDto fromEntity(Sangpum entity) {
    	return SangpumDto.builder()
                         .code(entity.getCode())
                         .sang(entity.getSang())
                         .su(entity.getSu())
                         .dan(entity.getDan())
                         .build();
    }

    public static List<SangpumDto> fromEntityList(List<Sangpum> entityList) {
        return entityList.stream()
                         .map(SangpumDto::fromEntity)
                         .collect(Collectors.toList());
    }
}

