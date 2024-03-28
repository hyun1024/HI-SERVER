package com.teamh.hiserver.user.service;

import com.teamh.hiserver.auth.util.JwtUtil;
import com.teamh.hiserver.user.dto.request.CheckRequestDto;
import com.teamh.hiserver.user.dto.request.LoginRequestDto;
import com.teamh.hiserver.user.dto.request.SignupRequestDto;
import com.teamh.hiserver.user.dto.request.UpdateUserRequestDto;
import com.teamh.hiserver.user.dto.request.UpdateAuthRequestDto;
import com.teamh.hiserver.user.dto.request.UpdatePasswordRequestDto;
import com.teamh.hiserver.user.dto.response.CheckResponseDto;
import com.teamh.hiserver.user.dto.response.LevelResponseDto;
import com.teamh.hiserver.user.dto.response.LoginResponseDto;
import com.teamh.hiserver.user.dto.response.MedalResponseDto;
import com.teamh.hiserver.user.dto.response.ProfileResponseDto;
import com.teamh.hiserver.user.dto.response.SignupResponseDto;
import com.teamh.hiserver.user.dto.response.UpdateAuthResponseDto;
import com.teamh.hiserver.user.entity.Level;
import com.teamh.hiserver.user.entity.Medal;
import com.teamh.hiserver.user.entity.User;
import com.teamh.hiserver.user.repository.LevelRepository;
import com.teamh.hiserver.user.repository.MedalRepository;
import com.teamh.hiserver.user.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final LevelRepository levelRepository;
    private final PasswordEncoder passwordEncoder;
    private final MedalRepository medalRepository;
    private final JwtUtil jwtUtil;
    public SignupResponseDto signup(SignupRequestDto signupRequestDto) {
        validation(signupRequestDto);
        Medal medal = medalRepository.findByMedalId(1L).orElse(null);
        Level level = levelRepository.findById(1L).orElse(null);
        User user = User.builder()
                .loginId(signupRequestDto.getLoginId())
                .nickname(signupRequestDto.getNickname())
                .password(passwordEncoder.encode(signupRequestDto.getPassword()))
                .level(level)
                .medal(medal)
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
        User user = userRepository.findById(loginRequestDto.getLoginId()).orElseThrow(() -> new NullPointerException("해당 유저 없음"));
        if(!passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())){
            throw new IllegalArgumentException("비밀번호가 틀립니다");
        };
        return LoginResponseDto.builder()
                .loginId(user.getLoginId())
                .nickname(user.getNickname())
                .build();
    }

    public CheckResponseDto checkIdValidity(CheckRequestDto checkRequestDto) {
        User user = userRepository.findById(checkRequestDto.getLoginId()).orElse(null);
        return CheckResponseDto.builder()
                .loginId(checkRequestDto.getLoginId())
                .isUsableId(user == null).build();
    }

    public ProfileResponseDto getProfile(String loginId) {
    	User user = userRepository.findById(loginId).orElseThrow(()->new NullPointerException("유효한 유저가 아닙니다."));
        Medal medal = user.getMedal();
        Level level = user.getLevel();
        LevelResponseDto levelDto = LevelResponseDto
        		.builder()
        		.level(level.getLevel())
        		.exp(level.getExp())
        		.build();
        MedalResponseDto medalDto = MedalResponseDto
		.builder()
		.medalId(medal.getMedalId())
		.imageUrl(medal.getImageUrl())
		.description(medal.getDescription())
		.name(medal.getName())
		.build();
        return ProfileResponseDto.builder()
                .exp(user.getExp())
                .gold(user.getGold())
                .level(levelDto)
                .medal(medalDto)
                .nickname(user.getNickname())
                .levelUpExp(level.getExp())
                .build();
    }
	public UpdateAuthResponseDto updateProfileAuth(HttpServletRequest request, UpdateAuthRequestDto requestDto) {
		String loginId = jwtUtil.getUser(request.getHeader("AccessToken"));
		User user = userRepository.findById(loginId).orElseThrow(()->new NullPointerException("유효한 유저가 아닙니다."));
		passwordEncoder.matches(user.getPassword(), requestDto.getPassword());
		return UpdateAuthResponseDto
				.builder()
				.isCorrect(passwordEncoder.matches(requestDto.getPassword() ,user.getPassword()))
				.build();
	}
    
    @Transactional
	public ProfileResponseDto updateProfile(HttpServletRequest request, UpdateUserRequestDto requestDto) {
		String loginId = jwtUtil.getUser(request.getHeader("AccessToken"));
		User user = userRepository.findById(loginId).orElseThrow(()->new NullPointerException("유효한 유저가 아닙니다."));
		Medal medal = medalRepository.findByMedalId(requestDto.getMedalId()).orElse(null);
        Level level = user.getLevel();
        LevelResponseDto levelDto = LevelResponseDto
        		.builder()
        		.level(level.getLevel())
        		.exp(level.getExp())
        		.build();
		user.updateProfile(requestDto.getNickname(), medal);
		Medal updateMedal = user.getMedal();
		MedalResponseDto medalDto = MedalResponseDto
				.builder()
				.medalId(updateMedal.getMedalId())
				.name(updateMedal.getName())
				.imageUrl(updateMedal.getImageUrl())
				.description(updateMedal.getDescription())
				.build();
		return ProfileResponseDto.builder()
                .exp(user.getExp())
                .gold(user.getGold())
                .level(levelDto)
                .medal(medalDto)
                .nickname(user.getNickname())
                .levelUpExp(level.getExp())
                .build();

	}
    @Transactional
	public ProfileResponseDto updatePassword(HttpServletRequest request, UpdatePasswordRequestDto requestDto) {
		String loginId = jwtUtil.getUser(request.getHeader("AccessToken"));
		User user = userRepository.findById(loginId).orElseThrow(()->new NullPointerException("유효한 유저가 아닙니다."));
		user.updatePassword(passwordEncoder.encode(requestDto.getPassword()));
		Medal medal = user.getMedal();
        Level level = user.getLevel();
        LevelResponseDto levelDto = LevelResponseDto
        		.builder()
        		.level(level.getLevel())
        		.exp(level.getExp())
        		.build();
		MedalResponseDto medalDto = MedalResponseDto
				.builder()
				.medalId(medal.getMedalId())
				.name(medal.getName())
				.imageUrl(medal.getImageUrl())
				.description(medal.getDescription())
				.build();
		return ProfileResponseDto.builder()
                .exp(user.getExp())
                .gold(user.getGold())
                .level(levelDto)
                .medal(medalDto)
                .nickname(user.getNickname())
                .levelUpExp(level.getExp())
                .build();

	}
}
