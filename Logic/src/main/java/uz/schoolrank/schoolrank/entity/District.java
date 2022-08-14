package uz.schoolrank.schoolrank.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import uz.schoolrank.schoolrank.entity.template.AbsLong;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicInsert
@DynamicUpdate
@Entity(name = "district")
//@Where(clause = "deleted=false")
//@SQLDelete(sql = "UPDATE district SET deleted=true WHERE id=?")
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_ru")
    private String nameRu;

    @Column(nullable = false, name = "name_en")
    private String nameEn;

    public District(String nameEn) {
        this.nameEn = nameEn;
    }
}
