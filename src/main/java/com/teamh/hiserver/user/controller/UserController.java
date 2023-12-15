package com.teamh.hiserver.user.controller;

import com.teamh.hiserver.user.dto.request.LoginRequestDto;
import com.teamh.hiserver.user.dto.request.SignupRequestDto;
import com.teamh.hiserver.user.dto.response.SignupResponseDto;
import com.teamh.hiserver.user.dto.response.LoginResponseDto;
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

    @RequestMapping("/api/user/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest request){
        LoginResponseDto loginResponseDto = userService.login(loginRequestDto, request);

        return ResponseEntity.status(200).body(loginResponseDto);
    }
}
