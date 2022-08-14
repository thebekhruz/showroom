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
@Entity(name = "admission")
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE admission SET deleted=true WHERE id=?")
public class Admission extends AbsUUID {

    @Column(nullable = false, name = "status")
    private boolean status;

    @Column(nullable = false, name = "count")
    private int count;

    @ManyToOne(fetch = FetchType.LAZY)
    private School school;
}
