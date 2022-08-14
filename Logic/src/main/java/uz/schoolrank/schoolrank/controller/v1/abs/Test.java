package uz.schoolrank.schoolrank.controller.v1.abs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/test")
public interface Test {
    @GetMapping
    String test();
}
