package uz.schoolrank.schoolrank.controller.v1.abs;

import org.springframework.web.bind.annotation.*;
import uz.schoolrank.schoolrank.entity.School;
import uz.schoolrank.schoolrank.entity.User;
import uz.schoolrank.schoolrank.payload.ApiResult;
import uz.schoolrank.schoolrank.payload.ConfirmDTO;
import uz.schoolrank.schoolrank.payload.req.OnlineFormAddDTO;
import uz.schoolrank.schoolrank.payload.res.OnlineFormGetDTO;
import uz.schoolrank.schoolrank.secret.CurrentUser;
import uz.schoolrank.schoolrank.utills.constants.Rest;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(OnlineFormController.ONLINE_FORM)
public interface OnlineFormController {

    String ONLINE_FORM = Rest.BASE_PATH_V1 + "online-form/";
    String GET_DATA = "data";
    String ADD_SCHOOL_FORM = "add-form";
    String GET_WAITING_SCHOOLS = "waiting-schools";
    String APPROVE_OR_REJECT = "confirm";

    @GetMapping(GET_DATA)
    ApiResult<OnlineFormGetDTO> getData();

    @GetMapping(GET_WAITING_SCHOOLS)
    ApiResult<List<School>> waitingSchools(@RequestParam(defaultValue = Rest.DEFAULT_PAGE_NUMBER) int page,
                                           @RequestParam(defaultValue = Rest.DEFAULT_PAGE_SIZE) int size);

    @PostMapping(APPROVE_OR_REJECT)
    ApiResult<?> confirm(@Valid @RequestBody ConfirmDTO dto);

    @PostMapping(ADD_SCHOOL_FORM)
    ApiResult<?> addForm(@Valid @RequestBody OnlineFormAddDTO dto, @CurrentUser User user);

}
