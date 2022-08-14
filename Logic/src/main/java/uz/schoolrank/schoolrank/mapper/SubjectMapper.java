package uz.schoolrank.schoolrank.mapper;

import org.mapstruct.Mapper;
import uz.schoolrank.schoolrank.entity.Subject;
import uz.schoolrank.schoolrank.payload.SubjectDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    List<SubjectDTO> toDTOList(List<Subject> subjectList);

}
