package com.teamh.hiserver.user.controller;

import com.teamh.hiserver.user.dto.AchieveListResponseDto;
import com.teamh.hiserver.user.dto.request.AchieveRequestDto;
import com.teamh.hiserver.user.dto.response.AchieveResponseDto;
import com.teamh.hiserver.user.service.AchieveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/achieve")
public class AchieveController {

    private final AchieveService achieveService;

    @PostMapping("/new")
    public ResponseEntity<AchieveResponseDto> setNewAchieve(@RequestBody AchieveRequestDto achieveRequestDto){

        return ResponseEntity.ok().body(achieveService.setNewAchieve(achieveRequestDto));
    }

    @GetMapping("/list")
    public ResponseEntity<AchieveListResponseDto> getAchieveList(@RequestBody Long userId){
        return ResponseEntity.ok().body(achieveService.getAchieveList(userId));
    }
}
