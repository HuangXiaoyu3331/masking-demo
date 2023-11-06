package com.masking.demo.controller;

import com.masking.demo.bean.vo.UserVO;
import com.masking.demo.core.ApiResponse;
import com.masking.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ApiResponse<UserVO> get(@PathVariable Integer userId) {
        return ApiResponse.createBySuccess(userService.getUser(userId));
    }

}
