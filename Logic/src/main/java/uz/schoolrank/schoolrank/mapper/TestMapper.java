package uz.schoolrank.schoolrank.mapper;

import org.mapstruct.Mapper;
import uz.schoolrank.schoolrank.entity.Test;
import uz.schoolrank.schoolrank.payload.TestDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TestMapper {

    List<TestDTO> toDTOList(List<Test> testList);

}
