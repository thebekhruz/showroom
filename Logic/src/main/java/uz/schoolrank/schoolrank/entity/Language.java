package uz.schoolrank.schoolrank.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import uz.schoolrank.schoolrank.entity.template.AbsLong;
import uz.schoolrank.schoolrank.entity.template.AbsUUIDNoUser;
import uz.schoolrank.schoolrank.enums.LanguageName;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicInsert
@DynamicUpdate
@Entity(name = "language")
//@Where(clause = "deleted=false")
//@SQLDelete(sql = "UPDATE language SET deleted=true WHERE id=?")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "name")
    @Enumerated(EnumType.STRING)
    private LanguageName languageName;

}
