package com.micro.member;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class MemberService {

    private final RestTemplate restTemplate;
    private final MemberRepository memberRepository;
    public void registerUser(MemberRegistrationRequest userRegistrationRequest) {
        Member member = Member.builder()
                .firstName(userRegistrationRequest.firstName())
                .lastName(userRegistrationRequest.lastName())
                .email(userRegistrationRequest.email())
                .build();

        // TODO: Validation Using Vetting
         // This saves to database
        memberRepository.saveAndFlush(member);

        VettingResponse vettingResponse = restTemplate.getForObject(
             "http://localhost:9999/api/vetting/{memberId}",
                VettingResponse.class,
                member.getId()
        );

        if(!vettingResponse.isValid()) {
            throw new IllegalStateException("Did not pass the Vetting Process");
        }

    }
}
