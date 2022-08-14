package uz.schoolrank.schoolrank.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import uz.schoolrank.schoolrank.entity.template.AbsLong;
import uz.schoolrank.schoolrank.enums.RoleName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(callSuper = true)
@Entity(name = "roles")
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE roles SET deleted=true WHERE id=?")
public class Role extends AbsLong implements GrantedAuthority {

    @Column(nullable = false, name = "role_name")
    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    @Override
    public String getAuthority() {
        return roleName.name();
    }
}
