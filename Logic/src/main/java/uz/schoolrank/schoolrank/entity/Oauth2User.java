package uz.schoolrank.schoolrank.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import uz.schoolrank.schoolrank.entity.template.AbsUUID;
import uz.schoolrank.schoolrank.enums.AuthProviderName;

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
@Entity(name = "oauth2_user")
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE oauth2_user SET deleted=true WHERE id=?")
public class Oauth2User extends AbsUUID {

    @Column(nullable = false, name = "name")
    private String name;

    @JoinColumn(insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false, name = "photo_url")
    private String photoUrl;

    @Column(nullable = false, name = "email_verificated")
    private boolean emailVerificated;

    @Column(nullable = false, name = "password")
    private String password;

    @Column(nullable = false, name = "provider")
    @Enumerated(EnumType.STRING)
    private AuthProviderName providerName;

}
