package uz.schoolrank.schoolrank.service.abs;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.schoolrank.schoolrank.payload.ApiResult;
import uz.schoolrank.schoolrank.payload.FileDTO;

import java.util.List;
import java.util.UUID;

public interface FileService {

    ApiResult<List<FileDTO>> uploadFile(MultipartHttpServletRequest file);

    ApiResult<FileDTO> getFile(UUID id);

    ApiResult<String> delete(UUID id);
}
