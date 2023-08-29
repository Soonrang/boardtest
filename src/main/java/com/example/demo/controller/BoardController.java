package com.example.demo.controller;

import com.example.demo.domain.Board;
import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/board")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    @GetMapping("/list")
    public String list(Model model) {
        List<Board> boardList = boardService.getAll();
        model.addAttribute("boardList", boardList);
        return "board/list"; // Assuming your Thymeleaf template name is "list.html"
    }

    @GetMapping("/register")
    public void registerGET() {

    }
    @PostMapping("/register")
    public String registerPost(@Valid BoardDTO boardDTO, BindingResult bindingResult , RedirectAttributes redirectAttributes ){
        log.info("등록처리");

        if(bindingResult.hasErrors()) {
            log.info("error");
            redirectAttributes.addFlashAttribute("error", bindingResult.getAllErrors());
            return "redirect:/board/register";
        }

        log.info(boardDTO);
        Long bno = boardService.register(boardDTO);
        redirectAttributes.addFlashAttribute("result",bno);
        return "redirect:/board/list";
    }
}