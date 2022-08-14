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
@Entity(name = "school_stage")
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE school_stage SET deleted=true WHERE id=?")
public class SchoolStage extends AbsUUID {

    @ManyToOne(fetch = FetchType.LAZY)
    private Stage stage;

    @ManyToOne(fetch = FetchType.LAZY)
    private School school;

    @Column(nullable = false, name = "count")
    private int count;

}