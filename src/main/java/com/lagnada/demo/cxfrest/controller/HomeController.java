package com.lagnada.demo.cxfrest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Sample controller for going to the home page with a message
 */
@Controller("homeController")
public class HomeController {

    private static final Logger logger = LoggerFactory
            .getLogger(HomeController.class);

    /**
     * Selects the home page and populates the model with a message
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home(Model model) {
        logger.info("Welcome home!");
        model.addAttribute("controllerMessage",
                "This is the message from the controller!");
        return new ModelAndView("home");
    }

}
