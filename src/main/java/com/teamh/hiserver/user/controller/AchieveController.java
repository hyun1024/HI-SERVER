package com.teamh.hiserver.user.controller;

import com.teamh.hiserver.user.service.AchieveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AchieveController {

    private final AchieveService achieveService;
}
