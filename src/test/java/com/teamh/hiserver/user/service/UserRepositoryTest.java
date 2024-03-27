package com.teamh.hiserver.user.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.teamh.hiserver.user.entity.User;
import com.teamh.hiserver.user.repository.UserRepository;

@SpringBootTest
public class UserRepositoryTest {
	
	private UserRepository userRepository;
	
	
    @Test
    void userRepositoryTest() {
    	
    	
        System.out.println("========case 1=========");
        User user = userRepository.findByUserId(1L).orElse(null);
        System.out.println("");
        System.out.println("========case 2=========");
        User user2 = userRepository.findById(1L).orElse(null);
        
    }
}
