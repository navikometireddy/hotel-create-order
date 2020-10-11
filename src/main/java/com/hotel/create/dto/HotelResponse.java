package com.hotel.create.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelResponse {

    private String statusCode;
    private String statusMessage;
    private Hotel hotel;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Hotel {
        private String hotelId;
        private String hotelName;
        private Date checkInDate;
        private Date checkOutDate;
    }
}
