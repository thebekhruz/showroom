package uz.schoolrank.schoolrank.controller.v1.impl;

import org.springframework.web.bind.annotation.RestController;
import uz.schoolrank.schoolrank.controller.v1.abs.Test;

@RestController
public class TestImpl implements Test {
    @Override
    public String test() {
        return "ukaam ishladi";
    }
}
