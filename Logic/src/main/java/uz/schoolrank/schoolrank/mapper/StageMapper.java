package uz.schoolrank.schoolrank.mapper;

import org.mapstruct.Mapper;
import uz.schoolrank.schoolrank.entity.Stage;
import uz.schoolrank.schoolrank.payload.StageDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StageMapper {

    List<StageDTO> toDTOList(List<Stage> stageList);

}
