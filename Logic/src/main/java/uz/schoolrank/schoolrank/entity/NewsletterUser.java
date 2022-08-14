package uz.schoolrank.schoolrank.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import uz.schoolrank.schoolrank.entity.template.AbsUUIDNoUser;

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
@Entity(name = "newsletter_user")
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE newsletter_user SET deleted=true WHERE id=?")
public class NewsletterUser extends AbsUUIDNoUser {

    @Column(name = "email", nullable = false, unique = true)
    private String email;

}
