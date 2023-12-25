package com.uas.kelompok4.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uas.kelompok4.models.TafsirModel;
import com.uas.kelompok4.services.QuranService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TafsirController {

    private final QuranService quranService;

    public TafsirController(QuranService quranService) {
        this.quranService = quranService;
    }

    @GetMapping("/tafsir/{id}")
    public String main(@PathVariable Long id, Model model) throws JsonProcessingException {

        String tafsirJString = quranService.getTafsir(id);

        ObjectMapper objectMapper = new ObjectMapper();

        TafsirModel tafsirObj = objectMapper.readValue(tafsirJString, TafsirModel.class);

        model.addAttribute("obj", tafsirObj);

        return "tafsir";
    }
}
