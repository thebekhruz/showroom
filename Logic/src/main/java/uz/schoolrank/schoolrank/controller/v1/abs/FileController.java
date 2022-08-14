package uz.schoolrank.schoolrank.controller.v1.abs;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.schoolrank.schoolrank.payload.ApiResult;
import uz.schoolrank.schoolrank.payload.FileDTO;
import uz.schoolrank.schoolrank.utills.constants.Rest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping(FileController.FILE)
public interface FileController {
    String FILE = Rest.BASE_PATH_V1 + "file/";
    String UPLOAD = FILE + "upload";
    String GET = FILE + "get/{id}";
    String DELETE = FILE + "delete/{id}";


    @PostMapping(UPLOAD)
    ApiResult<List<FileDTO>> uploadFile(MultipartHttpServletRequest file);

    @GetMapping(GET)
    ApiResult<FileDTO> getFile(@PathVariable UUID id);

    @DeleteMapping(DELETE)
    ApiResult<String> delete(@PathVariable UUID id);
}
