package com.teamh.hiserver.user.service;

import com.teamh.hiserver.user.repository.AchieveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AchieveService {

    private final AchieveRepository achieveRepository;
}
