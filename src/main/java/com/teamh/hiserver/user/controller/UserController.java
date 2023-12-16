package com.teamh.hiserver.user.controller;

import com.teamh.hiserver.user.dto.request.CheckRequestDto;
import com.teamh.hiserver.user.dto.response.CheckResponseDto;
import com.teamh.hiserver.user.dto.request.LoginRequestDto;
import com.teamh.hiserver.user.dto.request.SignupRequestDto;
import com.teamh.hiserver.user.dto.response.SignupResponseDto;
import com.teamh.hiserver.user.dto.response.LoginResponseDto;
import com.teamh.hiserver.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody SignupRequestDto signupRequestDto, HttpServletRequest request){
        return ResponseEntity.status(201).body(userService.signup(signupRequestDto, request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest request){
        return ResponseEntity.status(200).body(userService.login(loginRequestDto, request));
    }

    @PostMapping("/signup/validation")
    public ResponseEntity<CheckResponseDto> checkValidity(@RequestBody CheckRequestDto checkRequestDto, HttpServletRequest request){
        return ResponseEntity.status(200).body(userService.checkValidity(checkRequestDto, request));
    }
}
