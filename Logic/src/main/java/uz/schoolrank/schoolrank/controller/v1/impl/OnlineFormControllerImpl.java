package uz.schoolrank.schoolrank.controller.v1.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.schoolrank.schoolrank.controller.v1.abs.OnlineFormController;
import uz.schoolrank.schoolrank.entity.School;
import uz.schoolrank.schoolrank.entity.User;
import uz.schoolrank.schoolrank.payload.ApiResult;
import uz.schoolrank.schoolrank.payload.ConfirmDTO;
import uz.schoolrank.schoolrank.payload.req.OnlineFormAddDTO;
import uz.schoolrank.schoolrank.payload.res.OnlineFormGetDTO;
import uz.schoolrank.schoolrank.service.abs.OnlineFormService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OnlineFormControllerImpl implements OnlineFormController {

    private final OnlineFormService onlineFormService;

    @Override
    public ApiResult<OnlineFormGetDTO> getData() {
        return onlineFormService.getDataForOnlineForm();
    }

    @Override
    public ApiResult<List<School>> waitingSchools(int page, int size) {
        return onlineFormService.getWaitingSchools(page, size);
    }

    @Override
    public ApiResult<?> confirm(ConfirmDTO dto) {
        return onlineFormService.approveOrRejectSchools(dto);
    }

    @Override
    public ApiResult<?> addForm(OnlineFormAddDTO dto, User user) {
        return onlineFormService.saveOnlineForm(dto, user);
    }

}
