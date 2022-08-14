package uz.schoolrank.schoolrank.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import uz.schoolrank.schoolrank.entity.template.AbsUUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(callSuper = true)
@Entity(name = "attachment")
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE attachment SET deleted=true WHERE id=?")
public class Attachment extends AbsUUID {

    @Column(nullable = false, name = "file_name")
    private String fileName;

    @Column(nullable = false, name = "size")
    private Integer size;

    @Column(nullable = false, name = "original_name")
    private String originalName;

}
