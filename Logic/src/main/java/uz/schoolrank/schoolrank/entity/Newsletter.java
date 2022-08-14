package uz.schoolrank.schoolrank.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import uz.schoolrank.schoolrank.entity.template.AbsUUID;

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
@Entity(name = "newsletter")
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE newsletter SET deleted=true WHERE id=?")
public class Newsletter extends AbsUUID {

    @Column(nullable = false, name = "title")
    private String title;

    @Column(nullable = false, name = "body")
    private String body;

}
