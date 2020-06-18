package com.potager.deshalles.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@Slf4j
@Component
public class IndexController {

    private static final String TEMPLATE_INDEX = "/index";

    @GetMapping({"/", TEMPLATE_INDEX})
    public ModelAndView displayIndex(Map<String, Object> model) {

        return new ModelAndView( TEMPLATE_INDEX, model );
    }
}
