package com.example.demo.service.accommodations;

import com.example.demo.dto.AccommodationsDTO;

import java.util.List;

public interface AccommodationsService {

    Long register(AccommodationsDTO accommodationsDTO);
    List<AccommodationsDTO> list(AccommodationsDTO accommodationsDTO);

}
