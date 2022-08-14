package uz.schoolrank.schoolrank.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import uz.schoolrank.schoolrank.entity.template.AbsUUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(callSuper = true)
@Entity(name = "school_test")
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE school_test SET deleted=true WHERE id=?")
public class SchoolTest extends AbsUUID {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private School school;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Test test;

    @Column(nullable = false, name = "average_score")
    private double averageScore;

    @Column(nullable = false, name = "participation_rate")
    private double participationRate;

}
