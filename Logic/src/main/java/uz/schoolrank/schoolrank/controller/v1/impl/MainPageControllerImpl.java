package uz.schoolrank.schoolrank.controller.v1.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.schoolrank.schoolrank.controller.v1.abs.MainPageController;
import uz.schoolrank.schoolrank.payload.ApiResult;
import uz.schoolrank.schoolrank.payload.interfaceDTO.PopularDiscussionDTO;
import uz.schoolrank.schoolrank.payload.interfaceDTO.SchoolDTO;
import uz.schoolrank.schoolrank.service.abs.MainPageService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainPageControllerImpl implements MainPageController {

    private final MainPageService mainPageService;

    @Override
    public ApiResult<List<SchoolDTO>> search(String name, int page, int size) {
        return mainPageService.search(name, page, size);
    }

    @Override
    public ApiResult<List<PopularDiscussionDTO>> getPopularDiscussions(int page, int size) {
        return mainPageService.getDiscussions(page, size);
    }

    @Override
    public ApiResult<?> subscribeNewsletter(String email) {
        return mainPageService.subscribeNewsletter(email);
    }
}
