package io.skabillium.blog.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1")
public class HealthController {
    @GetMapping("/health")
    public String getStatus() {
        return "OK";
    }
}
