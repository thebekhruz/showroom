package uz.schoolrank.schoolrank.controller.v1.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.schoolrank.schoolrank.controller.v1.abs.FileController;
import uz.schoolrank.schoolrank.payload.ApiResult;
import uz.schoolrank.schoolrank.payload.FileDTO;
import uz.schoolrank.schoolrank.service.abs.FileService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class FileControllerImpl implements FileController {
    private final FileService fileService;
    @Override
    public ApiResult<List<FileDTO>> uploadFile(MultipartHttpServletRequest file) {
        log.info("AttachmentController => upload => enter:{}", file);
        ApiResult<List<FileDTO>> apiResult = fileService.uploadFile(file);
        log.info("AttachmentController => upload => enter:{}", apiResult);
        return apiResult;
    }

    @Override
    public ApiResult<FileDTO> getFile(UUID id) {
        return fileService.getFile(id);
    }

    @Override
    public ApiResult<String> delete(UUID id) {
        return fileService.delete(id);
    }
}
