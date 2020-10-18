package com.caerkea.searchuser.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String indexx() {
        return "index";
    }

    @GetMapping("/news")
    public String news() {
        return "newstimeline";
    }
}
