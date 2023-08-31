package com.example.demo.repository.search;

import com.example.demo.domain.Accommodations;
import com.example.demo.domain.QAccommodations;
import com.example.demo.dto.AccommodationsDTO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;


import java.time.LocalDate;
import java.util.List;

public class AccommodationsSearchImpl extends QuerydslRepositorySupport implements AccommodationsSearch {
    public AccommodationsSearchImpl() {
        super(Accommodations.class);
    }

    @Override
    public List<Accommodations> search1(AccommodationsDTO accommodationsDTO) {
        QAccommodations accommodations = QAccommodations.accommodations;
        JPQLQuery<Accommodations> query = from(accommodations);

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.or(accommodations.accommodations_Name.contains(" "));
        booleanBuilder.or(accommodations.location.contains("여수"));
        booleanBuilder.or(accommodations.accommodations_Feature.contains(""));

        query.where(booleanBuilder);
        query.where(accommodations.ano.gt(0L));

        List<Accommodations> list = query.fetch();

        return null;
    }

    @Override
    public List<Accommodations> searchAll(String[] types, String keyword) {

        QAccommodations accommodations = QAccommodations.accommodations;
        JPQLQuery<Accommodations> query = from(accommodations);

        if((types != null && types.length > 0) && types.length >0 && keyword != null){
            BooleanBuilder booleanBuilder = new BooleanBuilder();

            for (String type: types) {
                switch (type) {
                    case "n":
                        booleanBuilder.or(accommodations.accommodations_Name.contains(keyword));
                        break;
                    case "l":
                        booleanBuilder.or(accommodations.location.contains(keyword));
                        break;
                    case "f":
                        booleanBuilder.or(accommodations.accommodations_Feature.contains(keyword));
                        break;

                }
            }

            query.where(booleanBuilder);  // Use the booleanBuilder as the where condition

        }

        List<Accommodations> list = query.fetch();

        return list;
    }


//    @Override
//    public List<Accommodations> searchByDateRange(LocalDate startDate, LocalDate endDate) {
//        QAccommodations accommodations = QAccommodations.accommodations;
//        JPQLQuery<Accommodations> query = from(accommodations);
//
//        BooleanBuilder booleanBuilder = new BooleanBuilder();
//
//        booleanBuilder.and(accommodations.booking_sdate.between(startDate, endDate));
//
//        query.where(booleanBuilder);
//        query.where(accommodations.ano.gt(0L));
//
//        List<Accommodations> list = query.fetch();
//
//        return list;
//    }


}