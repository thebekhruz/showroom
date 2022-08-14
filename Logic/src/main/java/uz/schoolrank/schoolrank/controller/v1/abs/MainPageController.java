package uz.schoolrank.schoolrank.controller.v1.abs;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uz.schoolrank.schoolrank.payload.ApiResult;
import uz.schoolrank.schoolrank.payload.interfaceDTO.PopularDiscussionDTO;
import uz.schoolrank.schoolrank.payload.interfaceDTO.SchoolDTO;
import uz.schoolrank.schoolrank.utills.constants.Rest;

import java.util.List;

@RequestMapping(MainPageController.MAIN_PAGE)
public interface MainPageController {

    String MAIN_PAGE = Rest.BASE_PATH_V1+"main-page/";
    String SEARCH_SCHOOL = "search";
    String POPULAR_DISCUSSION = "populars";

    String SUBSCRIBE_NEWSLETTER = "subs-news";

    @GetMapping(SEARCH_SCHOOL)
    ApiResult<List<SchoolDTO>> search(@RequestParam String name,
                                      @RequestParam(defaultValue = Rest.DEFAULT_PAGE_NUMBER) int page,
                                      @RequestParam(defaultValue = Rest.DEFAULT_PAGE_SIZE) int size);

    @GetMapping(POPULAR_DISCUSSION)
    ApiResult<List<PopularDiscussionDTO>> getPopularDiscussions(@RequestParam(defaultValue = Rest.DEFAULT_PAGE_NUMBER) int page,
                                                                @RequestParam(defaultValue = Rest.DEFAULT_PAGE_SIZE) int size);

    @PostMapping(SUBSCRIBE_NEWSLETTER)
    ApiResult<?> subscribeNewsletter(@RequestParam String email);
}
