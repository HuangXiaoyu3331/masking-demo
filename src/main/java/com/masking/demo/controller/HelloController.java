package com.masking.demo.controller;

import com.masking.demo.bean.TestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @GetMapping("/test")
    public TestVO test() {
        TestVO vo = new TestVO();
        vo.setPhone("15688998800");
        vo.setIdCard("445267888899999999");
        vo.setEmail("108888888@qq.com");
        return vo;
    }

}
