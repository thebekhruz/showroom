package uz.schoolrank.schoolrank.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import uz.schoolrank.schoolrank.entity.template.AbsUUID;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(callSuper = true)
@Entity(name = "ads")
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE ads SET deleted=true WHERE id=?")
public class Ads extends AbsUUID {

    @Column(nullable = false, name = "title")
    private String title;

    @Column(nullable = false, name = "body")
    private String body;

    @Column(nullable = false, name = "link")
    private String link;

    @OneToOne(fetch = FetchType.LAZY)
    private Attachment attachment;

}
