package uz.schoolrank.schoolrank.service.abs;

import uz.schoolrank.schoolrank.entity.School;
import uz.schoolrank.schoolrank.entity.User;
import uz.schoolrank.schoolrank.payload.ApiResult;
import uz.schoolrank.schoolrank.payload.ConfirmDTO;
import uz.schoolrank.schoolrank.payload.req.OnlineFormAddDTO;
import uz.schoolrank.schoolrank.payload.res.OnlineFormGetDTO;

import java.util.List;

public interface OnlineFormService {

    ApiResult<OnlineFormGetDTO> getDataForOnlineForm();

    ApiResult<?> saveOnlineForm(OnlineFormAddDTO dto, User user);

    ApiResult<List<School>> getWaitingSchools(int page, int size);

    ApiResult<?> approveOrRejectSchools(ConfirmDTO dto);

}
