package com.teamh.hiserver.user.controller;

import com.teamh.hiserver.auth.util.JwtUtil;
import com.teamh.hiserver.user.dto.response.ProfileResponseDto;
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
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody @Valid SignupRequestDto signupRequestDto){
        return ResponseEntity.status(201).body(userService.signup(signupRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) throws UnsupportedEncodingException {
        LoginResponseDto loginResponseDto = userService.login(loginRequestDto);
        jwtUtil.addJwtToCookie(loginRequestDto.getLoginId(), response);
        return ResponseEntity.status(200).body(loginResponseDto);
    }

    @PostMapping("/signup/validation")
    public ResponseEntity<CheckResponseDto> checkValidity(@RequestBody CheckRequestDto checkRequestDto){
        return ResponseEntity.status(200).body(userService.checkValidity(checkRequestDto));
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<ProfileResponseDto> getProfile(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.getProfile(id));

    }
}
