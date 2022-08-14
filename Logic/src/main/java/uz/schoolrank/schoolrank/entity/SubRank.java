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
@Entity(name = "sub_rank")
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE sub_rank SET deleted=true WHERE id=?")
public class SubRank extends AbsUUID {

    @ManyToOne(fetch = FetchType.LAZY)
    private Feature feature;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Rank rank;

    @Column(nullable = false, name = "mark")
    private int mark;

}