package uz.schoolrank.schoolrank.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AwardsDTO {

    private Long id;

    private String name;

    private String description;

    private String photoUrl;

}
