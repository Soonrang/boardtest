package com.example.demo.repository.search;

import com.example.demo.domain.Accommodations;
import com.example.demo.dto.AccommodationsDTO;

import java.time.LocalDate;
import java.util.List;

public interface AccommodationsSearch {

    List<Accommodations> search1(AccommodationsDTO accommodationsDTO);
    List<Accommodations> searchAll(String[] types, String keyword);
    //List<Accommodations> searchByDateRange(LocalDate startDate, LocalDate endDate);
}
