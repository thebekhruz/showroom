package uz.schoolrank.schoolrank.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import uz.schoolrank.schoolrank.entity.Attachment;
import uz.schoolrank.schoolrank.payload.FileDTO;

@Mapper(componentModel = "spring")
public interface FileMapper {

    @Mappings({
            @Mapping(target = "url", source = "fileName"),
            @Mapping(target = "name", source = "originalName")

    })
    FileDTO toFileDTO(Attachment attachment);
}
