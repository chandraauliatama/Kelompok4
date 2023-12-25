package com.uas.kelompok4.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uas.kelompok4.models.QuranModel;
import com.uas.kelompok4.services.QuranService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final QuranService quranService;

    public HomeController(QuranService quranService) {
        this.quranService = quranService;
    }

    @GetMapping("/")
    public String main(Model model) throws JsonProcessingException {
        String allSuratJString = quranService.getAllSurat();

        ObjectMapper objectMapper = new ObjectMapper();

        QuranModel allSuratObj = objectMapper.readValue(allSuratJString, QuranModel.class);

        model.addAttribute("obj", allSuratObj);

        return "home";
    }
    
}
