package com.curadesk;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootTest
class CuradeskApplicationTests {

    @GetMapping("/test")
    public String testBackend() {
        return "Backend is running";
    }

}
