package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="sangdata")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sangpum {
    @Id
    private int code;
    private String sang;
    private int su, dan;
}
