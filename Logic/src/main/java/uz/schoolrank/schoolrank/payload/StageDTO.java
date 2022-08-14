package uz.schoolrank.schoolrank.payload;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class StageDTO {

    private UUID id;

    private String name;
}
