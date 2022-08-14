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
@Entity(name = "question")
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE question SET deleted=true WHERE id=?")
public class Question extends AbsUUID {

    @Column(nullable = false, name = "title")
    private String title;

    @Column(nullable = false, name = "body", columnDefinition = "text")
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    private Attachment attachment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

}