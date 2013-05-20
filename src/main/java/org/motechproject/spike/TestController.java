package org.motechproject.spike;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller@RequestMapping("/")
public class TestController {

    @ResponseBody
    @RequestMapping("/status")
    private String status() {
        return "Complimenti, si sta lavorando!";
    }
}
