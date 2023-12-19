package com.teamh.hiserver.user.service;

import com.teamh.hiserver.user.dto.request.LoginRequestDto;
import com.teamh.hiserver.user.dto.response.LoginResponseDto;
import com.teamh.hiserver.user.entity.User;
import com.teamh.hiserver.user.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    User user;
    @Mock
    PasswordEncoder passwordEncoder;
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userService;

    @BeforeEach
    void initUser() {
        user = User.builder().loginId("testId").nickname("testNickname").password("testPassword").build();
    }

    @Test
    void testCheckPasswordMatch() {
        LoginRequestDto loginRequestDto = LoginRequestDto.builder()
                .password("testPassword").build();
        given(userRepository.findByLoginId(loginRequestDto.getLoginId())).willReturn(Optional.ofNullable(user));
        given(passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())).willReturn(true);

        LoginResponseDto loginResponseDto = userService.login(loginRequestDto);
        Assertions.assertNotNull(loginResponseDto);
    }

    @Test
    void testCheckPasswordMismatch() {
        LoginRequestDto loginRequestDto = LoginRequestDto.builder()
                .password("wrongPassword").build();
        given(userRepository.findByLoginId(loginRequestDto.getLoginId())).willReturn(Optional.ofNullable(User.builder().password("testPassword").build()));

        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.login(loginRequestDto), "비밀번호가 틀립니다");
    }
}