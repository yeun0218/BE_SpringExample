package pack.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GogekDto {
	private int gogekno;
	private String gogekname;
	private String gender;
	private int age;
	private String gogektel;
	
	private String gogekjumin;

	public static GogekDto fromEntity(Gogek gogek) {
		
        return GogekDto.builder()
                .gogekno(gogek.getGogekno())
                .gogekname(gogek.getGogekname())
                .gender(GogekDto.getGender(gogek.getGogekjumin()))
                .age(GogekDto.getAge(gogek.getGogekjumin()))
                .gogektel(gogek.getGogektel())
                .gogekjumin(gogek.getGogekjumin())
                .build();
    }
	
	public static String getGender(String gogekjumin) {
        String genderCode = gogekjumin.substring(7, 8); // 주민번호의 뒷자리
        return ("1".equals(genderCode) || "3".equals(genderCode)) ? "남자" : "여자";
    }

    public static int getAge(String gogekjumin) {
        int year = Integer.parseInt(gogekjumin.substring(0, 2));
        int currentYear = LocalDate.now().getYear() % 100; // 현재 연도의 마지막 두 자리
        year += (year <= currentYear) ? 2000 : 1900; // 생년 계산
        return LocalDate.now().getYear() - year +1; // 나이 계산
    }

}
