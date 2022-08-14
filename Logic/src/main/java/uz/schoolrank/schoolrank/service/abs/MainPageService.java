package uz.schoolrank.schoolrank.service.abs;

import uz.schoolrank.schoolrank.payload.ApiResult;
import uz.schoolrank.schoolrank.payload.interfaceDTO.PopularDiscussionDTO;
import uz.schoolrank.schoolrank.payload.interfaceDTO.SchoolDTO;

import java.util.List;

public interface MainPageService {

    ApiResult<List<PopularDiscussionDTO>> getDiscussions(int page, int size);

    ApiResult<List<SchoolDTO>> search(String name, int page, int size);

    ApiResult<?> subscribeNewsletter(String email);

}
