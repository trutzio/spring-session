package io.trutz.springsession;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class Controller {

    @GetMapping("/")
    public String index(HttpSession httpSession) {
        var now = LocalDateTime.now();
        httpSession.setAttribute("ts", now);
        log.info("Now {}", now);
        return now.toString();
    }

}
