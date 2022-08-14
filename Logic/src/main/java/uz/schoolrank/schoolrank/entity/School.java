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
@Entity(name = "school")
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE school SET deleted=true WHERE id=?")
public class School extends AbsUUID {

    @Column(nullable = false, name = "name", unique = true)
    private String name;

    @Column(nullable = false, name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "website")
    private String website;

    @Column(nullable = false, name = "email", unique = true)
    private String email;

    @Column(nullable = false, name = "phone_number", unique = true)
    private String phoneNumber;

    @Column(nullable = false, name = "fax")
    private String fax;

    @OneToOne(fetch = FetchType.LAZY)
    private Attachment logo;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Address address;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EducationSystem system;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Language language;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private District district;

    @Column(nullable = false, name = "graduation_rate")
    private double graduationRate;

    @Column(nullable = false, name = "is_accepted")
    private boolean accepted;

    @Column(name = "rank_admin")
    private int rankAdmin;

}
