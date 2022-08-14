package uz.schoolrank.schoolrank.payload.interfaceDTO;

import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

public interface SchoolDTO {

    UUID getId();

    String getName();

//    String getDescription();
//
//    String getPhoneNumber();
//
//    String getWebsite();
//
//    String getEmail();
//
//    String getFax();
//
//    @Value("#{@addressRepository}")
//    AddressDTO getAddress();

}
