package com.potager.deshalles.controller;

import com.potager.deshalles.error.FirebaseException;
import com.potager.deshalles.error.JacksonUtilityException;
import com.potager.deshalles.service.FireDataBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Map;

@RestController
@Slf4j
@Component
public class IndexController {

    @Autowired
    private FireDataBaseService fireDataBaseService;

    private static final String TEMPLATE_INDEX = "/index";

    @GetMapping({"/", TEMPLATE_INDEX})
    public ModelAndView displayIndex(Map<String, Object> model) throws FirebaseException, IOException, JacksonUtilityException {

        model = fireDataBaseService.recupererAllPlats();

        return new ModelAndView(TEMPLATE_INDEX, model);
    }
}
