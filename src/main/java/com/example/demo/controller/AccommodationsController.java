package com.example.demo.controller;


import com.example.demo.domain.Accommodations;
import com.example.demo.dto.AccommodationsDTO;
import com.example.demo.service.accommodations.AccommodationsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/Accommodations")
@Log4j2
@RequiredArgsConstructor
public class AccommodationsController {

    private final AccommodationsService accommodationsService;

    @GetMapping("/list")
    public String list(@ModelAttribute("dto") AccommodationsDTO accommodationsDTO, Model model) {
        List<AccommodationsDTO> accommodationsList = accommodationsService.list(accommodationsDTO);
        model.addAttribute("accommodationsList", accommodationsList);
        return "accommodations/list";
    }

    @GetMapping("/register")
    public void registerGET() {
    }

    @PostMapping("/register")
    public String registerPost(@Valid AccommodationsDTO accommodationsDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info("등록!!");

        if(bindingResult.hasErrors()) {
            log.info("error");
            redirectAttributes.addFlashAttribute("error", bindingResult.getAllErrors());
            return "redirect:/Accommodations/list";
        }
        log.info(accommodationsDTO);
        Long ano = accommodationsService.register(accommodationsDTO);
        redirectAttributes.addFlashAttribute("result",ano);
        return "redirect:/Accommodations/list";
    }

}
