package com.teamh.hiserver.user.service;

import com.teamh.hiserver.user.dto.SignupRequestDto;
import com.teamh.hiserver.user.dto.SignupResponseDto;
import com.teamh.hiserver.user.entity.User;
import com.teamh.hiserver.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public SignupResponseDto signup(SignupRequestDto signupRequestDto, HttpServletRequest request) {
        validation(signupRequestDto);
        User user = User.builder()
                .loginId(signupRequestDto.getLoginId())
                .nickname(signupRequestDto.getNickname())
                .password(signupRequestDto.getPassword())
                .build();
        userRepository.save(user);
        return SignupResponseDto.builder().loginId(signupRequestDto.getLoginId()).build();
    }

    private void validation(SignupRequestDto signupRequestDto) {
        if(!signupRequestDto.getDuplication()) {
            throw new RuntimeException("중복 검사 안 됨");
        }
    }
}
