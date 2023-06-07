package com.micro.member;

import org.springframework.stereotype.Service;

@Service
public record MemberService(MemberRepository memberRepository) {
    public void registerUser(MemberRegistrationRequest userRegistrationRequest) {
        Member user = Member.builder()
                .firstName(userRegistrationRequest.firstName())
                .lastName(userRegistrationRequest.lastName())
                .email(userRegistrationRequest.email())
                .build();

        // TODO: Validation

        // This saves to database
        memberRepository.save(user);
    }
}
