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
        var now = httpSession.getAttribute("ts");
        if (now == null) {
            now = LocalDateTime.now();
            httpSession.setAttribute("ts", now.toString());
            log.info("new ts {}", now);
            return now.toString();
        }
        return now.toString();
    }

}
