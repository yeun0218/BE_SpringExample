package pack.model;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "buser")
@Getter
public class Buser {
    @Id
    private int buserno;
    private String busername;
    private String busertel;
    
    @JsonManagedReference
    @OneToMany(mappedBy = "buser", fetch = FetchType.LAZY)
    private List<Jikwon> jikwonList;    
}