package com.teamh.hiserver.user.controller;

import com.teamh.hiserver.user.dto.request.AchieveRequestDto;
import com.teamh.hiserver.user.dto.response.AchieveResponseDto;
import com.teamh.hiserver.user.service.AchieveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/achieve")
public class AchieveController {

    private final AchieveService achieveService;

    @PostMapping("/first")
    public ResponseEntity<AchieveResponseDto> getFirstAchieve(AchieveRequestDto achieveRequestDto){

        return ResponseEntity.ok().body(achieveService.getFirstAchieve(achieveRequestDto));
    }
}
