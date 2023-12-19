package com.teamh.hiserver.user.controller;

import com.teamh.hiserver.user.dto.request.CheckRequestDto;
import com.teamh.hiserver.user.dto.request.LoginRequestDto;
import com.teamh.hiserver.user.dto.request.SignupRequestDto;
import com.teamh.hiserver.user.dto.response.CheckResponseDto;
import com.teamh.hiserver.user.dto.response.LoginResponseDto;
import com.teamh.hiserver.user.dto.response.SignupResponseDto;
import com.teamh.hiserver.user.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody @Valid SignupRequestDto signupRequestDto){
        return ResponseEntity.status(201).body(userService.signup(signupRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response){
        return ResponseEntity.status(200).body(userService.login(loginRequestDto, response));
    }

    @PostMapping("/signup/validation")
    public ResponseEntity<CheckResponseDto> checkValidity(@RequestBody CheckRequestDto checkRequestDto){
        return ResponseEntity.status(200).body(userService.checkValidity(checkRequestDto));
    }
}
