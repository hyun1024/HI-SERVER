package com.teamh.hiserver.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ValidPasswordRequestDto {
    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z]).{8,16}", message = "비밀번호는 숫자와 영어 8~16자로 입력해주세요.")
    private String password;
}
