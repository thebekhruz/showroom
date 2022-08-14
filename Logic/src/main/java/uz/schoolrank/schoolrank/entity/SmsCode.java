package uz.schoolrank.schoolrank.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import uz.schoolrank.schoolrank.entity.template.AbsUUIDNoUser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(callSuper = true)
@Entity(name = "sms_code")
@Table(indexes = @Index(columnList = "email"))
public class SmsCode extends AbsUUIDNoUser {

    // FOYDALANUVCHIGA YUBORILGAN SMS CODE
    @Column(nullable = false, name = "code")
    private String code;

    //FOYDALANUVCHI EMAIL MANZILI
    @Column(nullable = false, name = "email")
    private String email;

    //FOYDALANUVCHI BU KODNI TEKSHIRIB BOLDIMI
    @Column(nullable = false, name = "checked")
    private Boolean checked = false;

    //USHBU COLUMN TRUE BO'LSA YANGI PASSWORD SET QILINMAYDI
    @Column(name = "checked_for_reset")
    private Boolean checkedForReset = false;




}
