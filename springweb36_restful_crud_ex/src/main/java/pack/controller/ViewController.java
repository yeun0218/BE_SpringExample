package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    // 진입 페이지 
    @GetMapping("/")
    public String index() {
        return "list";
    }
}