package com.uas.kelompok4.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uas.kelompok4.models.SuratModel;
import com.uas.kelompok4.services.QuranService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SuratController {

    private final QuranService quranService;

    public SuratController(QuranService quranService) {
        this.quranService = quranService;
    }

    @GetMapping("/surat/{id}")
    public String main(@PathVariable Long id, Model model) throws JsonProcessingException {

        String suratJString = quranService.getSurat(id);

        ObjectMapper objectMapper = new ObjectMapper();

        SuratModel suratObj = objectMapper.readValue(suratJString, SuratModel.class);

        model.addAttribute("obj", suratObj);

        return "surat";
    }
}

