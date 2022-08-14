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
@Entity(name = "address")
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE address SET deleted=true WHERE id=?")
public class Address extends AbsUUID {

    @Column(nullable = false, name = "lan")
    private double lan;

    @Column(nullable = false, name = "lat")
    private double lat;

}

