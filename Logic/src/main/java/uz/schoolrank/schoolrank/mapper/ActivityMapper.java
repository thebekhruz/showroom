package uz.schoolrank.schoolrank.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import uz.schoolrank.schoolrank.entity.Activity;
import uz.schoolrank.schoolrank.payload.ActivityDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActivityMapper {


    List<ActivityDTO> toDTOList(List<Activity> activityList);

}
