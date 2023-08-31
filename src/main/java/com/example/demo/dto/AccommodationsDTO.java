package com.example.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccommodationsDTO {

    private Long ano;

    @NotEmpty
    private String accommodations_Name;

    @NotEmpty
    private String accommodations_Feature;

    @NotEmpty
    private String location;

    private LocalDate booking_sdate;
    private LocalDate booking_edate;

    private String type;
    private String keyword;

    public String[] getTypes(){
        if(type==null || type.isEmpty()){
            return null;
        }
        return type.split("");
    }

    private  String link;

    public String getLink() {
        if (link == null) {
            StringBuilder builder = new StringBuilder();

            if (type != null && type.length() > 0) {
                builder.append("type=" + type);
            }

            if (keyword != null) {
                try {
                    builder.append("&keyword=" + URLEncoder.encode(keyword, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    // 처리 코드 추가
                }
            }

            link = builder.toString();
        }

        return link;
    }


}
