package org.meleschkin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SuppressWarnings("unused")
@Controller
public class HelloWorldController {

    @SuppressWarnings({"unused", "SameReturnValue"})
    @RequestMapping
    public String index() {
        return "index";
    }
}
