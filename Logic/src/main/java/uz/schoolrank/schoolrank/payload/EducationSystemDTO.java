package uz.schoolrank.schoolrank.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EducationSystemDTO {

    private Long id;

    private String name;

}
