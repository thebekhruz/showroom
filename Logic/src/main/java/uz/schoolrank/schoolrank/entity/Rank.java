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
@Entity(name = "rank")
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE rank SET deleted=true WHERE id=?")
public class Rank extends AbsUUID {

    @ManyToOne(fetch = FetchType.LAZY)
    private School school;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(nullable = false, name = "overall")
    private int overall;

    @Column(nullable = false, name = "recommend")
    private boolean recommend;

    @Column(nullable = false, name = "description")
    private String description;

}

