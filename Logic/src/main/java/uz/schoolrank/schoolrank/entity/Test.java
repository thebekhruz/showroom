package uz.schoolrank.schoolrank.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import uz.schoolrank.schoolrank.entity.template.AbsLong;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(callSuper = true)
@Entity(name = "test")
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE test SET deleted=true WHERE id=?")
public class Test extends AbsLong {

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "max_score")
    private double maxScore;

}
