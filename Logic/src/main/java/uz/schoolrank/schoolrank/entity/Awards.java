package uz.schoolrank.schoolrank.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import uz.schoolrank.schoolrank.entity.template.AbsLong;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(callSuper = true)
@Entity(name = "awards")
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE awards SET deleted=true WHERE id=?")
public class Awards extends AbsLong {

    @Column(nullable = false, name = "name", unique = true)
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    private Attachment attachment;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(nullable = false, name = "description", columnDefinition = "text")
    private String description;

    @ManyToMany
    private List<School> schoolList;

}