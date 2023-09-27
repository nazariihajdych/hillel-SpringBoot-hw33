package ua.hillel.springbootapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ping")
@Slf4j
public class PingController {
    @GetMapping
    public @ResponseBody
    ResponseEntity<String> ping(){
        log.info("Ping controller in use");
        return ResponseEntity.ok("OK");
    }
}
