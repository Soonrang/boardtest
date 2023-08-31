package com.example.demo.service.accommodations;

import com.example.demo.domain.Accommodations;
import com.example.demo.dto.AccommodationsDTO;
import com.example.demo.repository.AccommodationsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class AccommodationsServiceImpl implements AccommodationsService{

    private final ModelMapper modelMapper;
    private final AccommodationsRepository accommodationsRepository;


    @Override
    public Long register(AccommodationsDTO accommodationsDTO) {
        Accommodations accommodations = modelMapper.map(accommodationsDTO, Accommodations.class);
        Long ano = accommodationsRepository.save(accommodations).getAno();
        return ano;
    }

    @Override
    public List<AccommodationsDTO> list(AccommodationsDTO accommodationsDTO) {
        String[] types = accommodationsDTO.getTypes();
        String keyword = accommodationsDTO.getKeyword();

        List<Accommodations> result = accommodationsRepository.searchAll(types, keyword);

        List<AccommodationsDTO> dtoList = result.stream()
                .map(accommodations -> modelMapper.map(accommodations, AccommodationsDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }


}
