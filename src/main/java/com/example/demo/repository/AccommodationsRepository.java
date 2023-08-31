package com.example.demo.repository;


import com.example.demo.domain.Accommodations;
import com.example.demo.repository.search.AccommodationsSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationsRepository extends JpaRepository<Accommodations, Long>, AccommodationsSearch {

}
