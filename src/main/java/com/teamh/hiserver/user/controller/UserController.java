package com.teamh.hiserver.user.controller;

import com.teamh.hiserver.user.dto.SignupRequestDto;
import com.teamh.hiserver.user.dto.SignupResponseDto;
import com.teamh.hiserver.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @RequestMapping("/api/user/signup")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody SignupRequestDto signupRequestDto, HttpServletRequest request){
        SignupResponseDto signupResponseDto = userService.signup(signupRequestDto, request);

        return ResponseEntity.status(201).body(signupResponseDto);
    }
}
