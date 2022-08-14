package uz.schoolrank.schoolrank.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import uz.schoolrank.schoolrank.entity.Awards;
import uz.schoolrank.schoolrank.payload.AwardsDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AwardMapper {

    List<AwardsDTO> toDTOList(List<Awards> awardsList);

}
