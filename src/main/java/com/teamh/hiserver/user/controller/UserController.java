package com.teamh.hiserver.user.controller;

import com.teamh.hiserver.auth.util.JwtUtil;
import com.teamh.hiserver.user.dto.response.ProfileResponseDto;
import com.teamh.hiserver.user.dto.request.CheckRequestDto;
import com.teamh.hiserver.user.dto.request.LoginRequestDto;
import com.teamh.hiserver.user.dto.request.SignupRequestDto;
import com.teamh.hiserver.user.dto.request.UpdateUserRequestDto;
import com.teamh.hiserver.user.dto.request.UpdateAuthRequestDto;
import com.teamh.hiserver.user.dto.request.UpdatePasswordRequestDto;
import com.teamh.hiserver.user.dto.response.CheckResponseDto;
import com.teamh.hiserver.user.dto.response.LoginResponseDto;
import com.teamh.hiserver.user.dto.response.SignupResponseDto;
import com.teamh.hiserver.user.dto.response.UpdateAuthResponseDto;
import com.teamh.hiserver.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
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

    @PostMapping("/signup/validation")
    public ResponseEntity<CheckResponseDto> checkIdValidity(@RequestBody CheckRequestDto checkRequestDto){
        return ResponseEntity.status(200).body(userService.checkIdValidity(checkRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) throws UnsupportedEncodingException {
        LoginResponseDto loginResponseDto = userService.login(loginRequestDto);
        jwtUtil.addJwtToCookie(loginRequestDto.getLoginId(), response);
        return ResponseEntity.status(200).body(loginResponseDto);
    }
    
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletResponse response) throws UnsupportedEncodingException {
        return ResponseEntity.status(200).body("1");
    }

    @GetMapping("/profile")
    public ResponseEntity<ProfileResponseDto> getProfile(HttpServletRequest request){
        return ResponseEntity.ok().body(userService.getProfile(jwtUtil.getUser(request.getHeader("AccessToken"))));
    }
    @PutMapping("/profile")
    public ResponseEntity<ProfileResponseDto> updateProfile(HttpServletRequest request, @RequestBody UpdateUserRequestDto updateRequestDto){
    	return ResponseEntity.ok().body(userService.updateProfile(request, updateRequestDto));
    }
    @PutMapping("/profile/password")
    public ResponseEntity<ProfileResponseDto> updatePassword(HttpServletRequest request, @RequestBody @Valid UpdatePasswordRequestDto updateRequestDto){
    	return ResponseEntity.ok().body(userService.updatePassword(request, updateRequestDto));
    }
    @PostMapping("profile/auth")
    public ResponseEntity<UpdateAuthResponseDto> updateProfileAuth(HttpServletRequest request, @RequestBody UpdateAuthRequestDto requestDto){
    	return ResponseEntity.ok().body(userService.updateProfileAuth(request, requestDto));
    }
}
