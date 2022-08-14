package uz.schoolrank.schoolrank.payload.interfaceDTO;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Timestamp;
import java.util.UUID;

public interface PopularDiscussionDTO {

    UUID getId();

    String getTitle();

    String getBody();

    String getUsername();

    Timestamp getWrittenTime();

    String getPhotoUrl();

    @Value("#{@viewsRepository.countOfViews(target.id)}")
    long getViews();

    @Value("#{@sharesRepository.countOfShares(target.id)}")
    long getShares();

}
