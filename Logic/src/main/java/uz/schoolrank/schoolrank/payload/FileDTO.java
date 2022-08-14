package uz.schoolrank.schoolrank.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.schoolrank.schoolrank.utills.constants.Message;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FileDTO {

    @NotNull(message = Message.ID_NOT_FOUND)
    private UUID id;
    private String name;
    private String url;
    private Long size;
}
