package uz.schoolrank.schoolrank.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.schoolrank.schoolrank.entity.NewsletterUser;
import uz.schoolrank.schoolrank.entity.School;
import uz.schoolrank.schoolrank.exceptions.RestException;
import uz.schoolrank.schoolrank.payload.ApiResult;
import uz.schoolrank.schoolrank.payload.interfaceDTO.PopularDiscussionDTO;
import uz.schoolrank.schoolrank.payload.interfaceDTO.SchoolDTO;
import uz.schoolrank.schoolrank.repository.NewsletterUserRepository;
import uz.schoolrank.schoolrank.repository.QuestionRepository;
import uz.schoolrank.schoolrank.repository.SchoolRepository;
import uz.schoolrank.schoolrank.service.abs.MainPageService;
import uz.schoolrank.schoolrank.utills.constants.Message;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MainPageServiceImpl implements MainPageService {

    private final QuestionRepository questionRepository;
    private final SchoolRepository schoolRepository;
    private final NewsletterUserRepository newsletterUserRepository;

    @Override
    public ApiResult<List<PopularDiscussionDTO>> getDiscussions(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ApiResult.success(questionRepository.allPopularDiscussions(pageable));
    }

    @Override
    public ApiResult<List<SchoolDTO>> search(String name, int page, int size) {
        if (name.trim().equals(""))
            return ApiResult.success(new ArrayList<>());
        Pageable pageable = PageRequest.of(page, size);
        return ApiResult.success(schoolRepository.search(name.toUpperCase(), pageable));
    }

    @Override
    public ApiResult<?> subscribeNewsletter(String email) {
        if (newsletterUserRepository.existsByEmail(email))
            throw RestException.restThrow(Message.THIS_EMAIL_ALREADY_EXISTED, HttpStatus.BAD_REQUEST);
        NewsletterUser newsletterUser = NewsletterUser.builder().email(email).build();
        newsletterUserRepository.save(newsletterUser);
        return ApiResult.success(Message.YOU_SUBSCRIBED_TO_OUR_NEWSLETTER);
    }
}
