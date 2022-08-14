package uz.schoolrank.schoolrank.mapper;

import org.mapstruct.Mapper;
import uz.schoolrank.schoolrank.entity.EducationSystem;
import uz.schoolrank.schoolrank.payload.EducationSystemDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EducationSystemMapper {

    List<EducationSystemDTO> toDTOList(List<EducationSystem> systemList);

}
