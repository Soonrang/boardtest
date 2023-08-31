package com.example.demo.accommondations;

import com.example.demo.dto.AccommodationsDTO;
import com.example.demo.service.accommodations.AccommodationsService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Log4j2
public class AccommodationsTests {

    @Autowired
    private AccommodationsService accommodationsService;

    @Test
    public void testRegister() {
        log.info(accommodationsService.getClass().getName());

        AccommodationsDTO accommodationsDTO = AccommodationsDTO.builder()
                .accommodations_Name("여수 라마다프라자 호텔")
                .accommodations_Feature("바다")
                .location("전라남도 여수시 돌산읍 강남로 11")
                .booking_sdate(LocalDate.of(2023,8,29))
                .booking_edate(LocalDate.of(2023,9,29))
                .build();

                Long ano = accommodationsService.register(accommodationsDTO);
                log.info("ano : " + ano);

    }

//    @Test
//    public void testList() {
//        AccommodationsDTO accommodationsDTO = AccommodationsDTO.builder()
//                .type("f")
//                .keyword("바다")
//                .build();
//
//        List<AccommodationsDTO> accommodationsDTOList = accommodationsService.list(accommodationsDTO);
//        log.info(accommodationsDTO);
//    }

    @Test
    public void testList() {
        AccommodationsDTO accommodationsDTO = AccommodationsDTO.builder()
                .type("f")
                .keyword("바다")
                .build();

        accommodationsService.list(accommodationsDTO).forEach(dto -> {
            System.out.println(dto.getAccommodations_Name());
        });
    }


}
