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
@Entity(name = "anonymous_user")
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE anonymous_user SET deleted=true WHERE id=?")
public class AnonymousUser extends AbsUUID {

    @Column(nullable = false, name = "ip", updatable = false)
    private String ip;

    @Column(nullable = false, name = "browser_data", updatable = false)
    private String browserData;

}


