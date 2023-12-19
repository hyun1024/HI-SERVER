package com.teamh.hiserver.user.service;

import com.teamh.hiserver.auth.util.JwtUtil;
import com.teamh.hiserver.user.dto.request.CheckRequestDto;
import com.teamh.hiserver.user.dto.request.LoginRequestDto;
import com.teamh.hiserver.user.dto.request.SignupRequestDto;
import com.teamh.hiserver.user.dto.response.CheckResponseDto;
import com.teamh.hiserver.user.dto.response.LoginResponseDto;
import com.teamh.hiserver.user.dto.response.SignupResponseDto;
import com.teamh.hiserver.user.entity.User;
import com.teamh.hiserver.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    public SignupResponseDto signup(SignupRequestDto signupRequestDto) {
        validation(signupRequestDto);
        User user = User.builder()
                .loginId(signupRequestDto.getLoginId())
                .nickname(signupRequestDto.getNickname())
                .password(passwordEncoder.encode(signupRequestDto.getPassword()))
                .build();
        userRepository.save(user);
        return SignupResponseDto.builder().loginId(signupRequestDto.getLoginId()).build();
    }

    private void validation(SignupRequestDto signupRequestDto) {
        if (!signupRequestDto.getIsValid()) {
            throw new RuntimeException("중복 검사 안 됨");
        }
    }

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        User user = userRepository.findByLoginId(loginRequestDto.getLoginId()).orElseThrow(() -> new NullPointerException("해당 유저 없음"));
        if(!passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())){
            throw new IllegalArgumentException("비밀번호가 틀립니다");
        };
        return LoginResponseDto.builder()
                .userId(user.getUserId())
                .nickname(user.getNickname())
                .exp(user.getExp())
                .level(user.getLevel())
                .medal(user.getMedal())
                .gold(user.getGold())
                .build();
    }

    public CheckResponseDto checkValidity(CheckRequestDto checkRequestDto) {
        User user = userRepository.findByLoginId(checkRequestDto.getLoginId()).orElse(null);
        return CheckResponseDto.builder()
                .loginId(checkRequestDto.getLoginId())
                .isUsableId(user == null).build();
    }
}
