package com.micro.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/users")
public record MemberController(MemberService memberService) {
    @PostMapping
    public void registerUser(@RequestBody MemberRegistrationRequest memberRegistrationRequest) {
        log.info("new member {}", memberRegistrationRequest);
        memberService.registerUser(memberRegistrationRequest);
    }
}
