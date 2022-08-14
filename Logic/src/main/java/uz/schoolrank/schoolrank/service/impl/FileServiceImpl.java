package uz.schoolrank.schoolrank.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.schoolrank.schoolrank.component.MessageService;
import uz.schoolrank.schoolrank.entity.Attachment;
import uz.schoolrank.schoolrank.exceptions.RestException;
import uz.schoolrank.schoolrank.mapper.FileMapper;
import uz.schoolrank.schoolrank.payload.ApiResult;
import uz.schoolrank.schoolrank.payload.FileDTO;
import uz.schoolrank.schoolrank.repository.AttachmentRepository;
import uz.schoolrank.schoolrank.service.abs.FileService;
import uz.schoolrank.schoolrank.utills.constants.Message;
import uz.schoolrank.schoolrank.utills.constants.Rest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileServiceImpl implements FileService {
    private final AttachmentRepository attachmentRepository;
    private final FileMapper fileMapper;

    @Override
    @Transactional
    public ApiResult<List<FileDTO>> uploadFile(MultipartHttpServletRequest request) {
        Iterator<String> fileNames = request.getFileNames();
        List<FileDTO> fileDTOS = new ArrayList<>();
        while (fileNames.hasNext()) {
            MultipartFile file = request.getFile(fileNames.next());
            if (file != null) {
                checkFileContent(Objects.requireNonNull(file.getContentType()));

                //FILEDAN ATTACHMENTNI OLADIGAN METOHD
                Attachment attachment = attachmentToFile(file);

                //FILEDTO LISTGA HAMMA SAQLAGAN FILERNI SAQLAYABMIZ RESPONSE UCHUN
                fileDTOS.add(toFileDto(attachment));

                // BU METHOD PATH YASAB BERADI. YA'NI FILENI PAPKALAR ICHIGA TAXLAB SAQLAYMIZ
                Path path = createPath(attachment.getFileName());

                // BERILGAN PATH GA KO'RSATILGAN YO'LGA FILENI BYTE[] NI SAQLAYDI.SAQLOLMASA EXCEPTIONGA OTILADI
                fileSaveSystem(file, path);
            }
        }
        return ApiResult.success(fileDTOS);
    }

    private FileDTO toFileDto(Attachment attachment) {
        return FileDTO.builder()
                .id(attachment.getId())
                .name(attachment.getOriginalName())
                .url(attachment.getFileName())
                .size(Long.valueOf(attachment.getSize()))
                .build();

    }


    @Override
    public ApiResult<FileDTO> getFile(UUID id) {
        //AGAR FILE TOPILMASA THROW GA OTAMIZ
        ifFileNotFoundThrow(id);

        return ApiResult.success(fileMapper.toFileDTO(attachmentRepository.getReferenceById(id)));
    }

    @Override
    public ApiResult<String> delete(UUID id) {
        //AGAR FILE TOPILMASA THROW GA OTAMIZ
        ifFileNotFoundThrow(id);

        attachmentRepository.deleteById(id);
        return ApiResult.success(Message.SUCCESSFULLY + Message.DELETE);
    }


    private void checkFileContent(String contentType) {
        if (!contentType.startsWith("image/"))
            throw RestException.restThrow(Message.FILE_IS_FORBIDDEN, HttpStatus.BAD_REQUEST);
    }

    //MULTIPART FILENI SAVE QILIB ATTACHMENT QAYTARDIM
    private Attachment attachmentToFile(MultipartFile file) {
        return attachmentRepository.save(Attachment.builder()
                .originalName(file.getOriginalFilename())
                .fileName(createFileUrl(Objects.requireNonNull(file.getOriginalFilename())))
                .size((int) file.getSize())
                .build());
    }

    // XAR BIR FILEGA UNIQUE NAME YASAB BERADIGAN METHOD
    private String createFileUrl(String originalFilename) {
        String name = UUID.randomUUID().toString();
        String[] split = originalFilename.split("\\.");
        String contentType = split[split.length - 1];
        name = name + "." + contentType;
        return name;
    }

    //PAPKALARNI YO'LINI TAXLAB YOZIB BERADI     EX:  =>  D:\PDP\ECMA\AI
    private String collectFolder() {
        DateFormat dateFormat = new SimpleDateFormat("MMMMMMM");
        Calendar calendar = Calendar.getInstance();
        String year = calendar.get(Calendar.YEAR) + "";
        String month = dateFormat.format(new Date());
        String day = calendar.get(Calendar.DAY_OF_MONTH) + "";
        String hour = calendar.get(Calendar.HOUR_OF_DAY) + "";
        return Rest.FILE_PATH + "/" + year + "/" + month + "/" + day + "/" + hour;
    }

    // BERILGAN YOL BOYICHA PAPKALARNI OCHIB BERADI
    private void createFolder(String folder) {
        File file = new File(folder);
        file.mkdirs();
    }

    private Path createPath(String fileName) {

        //PAPKALARNI YO'LINI TAXLAB YOZIB BERADI   EX:  =>  D:\PDP\ECMA\AI
        String folder = collectFolder();

        // BERILGAN YOL BOYICHA PAPKALARNI OCHIB BERADI
        createFolder(folder);

        String pathString = folder + "/" + fileName;
        return Paths.get(pathString);
    }

    private void fileSaveSystem(MultipartFile file, Path path) {
        try {
            Files.copy(file.getInputStream(), path);
        } catch (IOException e) {
            //FILE_GET_INPUTSTREM bundle qoshmadim hali
            throw RestException.restThrow(MessageService.getMessage("FILE_GET_INPUTSTREM"), HttpStatus.BAD_REQUEST);
        }
    }

    private void ifFileNotFoundThrow(UUID id) {
        if (!attachmentRepository.existsById(id)) throw RestException.restThrow(Message.ID_NOT_FOUND, HttpStatus.BAD_REQUEST);
    }
}
