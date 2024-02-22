package com.teamh.hiserver.user.service;

import com.teamh.hiserver.user.dto.request.AchieveRequestDto;
import com.teamh.hiserver.user.dto.response.AchieveResponseDto;
import com.teamh.hiserver.user.entity.Achievement;
import com.teamh.hiserver.user.entity.Medal;
import com.teamh.hiserver.user.entity.User;
import com.teamh.hiserver.user.repository.AchieveRepository;
import com.teamh.hiserver.user.repository.MedalRepository;
import com.teamh.hiserver.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AchieveService {

    private final MedalRepository medalRepository;
    private final AchieveRepository achieveRepository;
    private final UserRepository userRepository;

    public AchieveResponseDto getNewAchieve(AchieveRequestDto achieveRequestDto) {
       User user = userRepository.findByUserId(achieveRequestDto.getUserId()).orElseThrow(()->new NullPointerException("유효한 유저가 아닙니다."));
       Medal medal = medalRepository.findByMedalId(achieveRequestDto.getMedalId()).orElseThrow(()->new NullPointerException("유효한 메달이 아닙니다."));
        Achievement achievement = Achievement.builder()
                .user(user)
                .medal(medal)
                .build();
        achieveRepository.save(achievement);
        return AchieveResponseDto.builder()
                .medalId(medal.getMedalId())
                .medalName(medal.getName())
                .medalUrl(medal.getImageUrl())
                .build();
    }
}
