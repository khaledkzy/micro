package com.micro.member;

import com.micro.clients.alert.AlertClient;
import com.micro.clients.alert.AlertRequest;
import com.micro.clients.vetting.VettingClient;
import com.micro.clients.vetting.VettingResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class MemberService {

    private final AlertClient alertClient;
    private final MemberRepository memberRepository;
    private final VettingClient vettingClient;

    public void registerUser(MemberRegistrationRequest userRegistrationRequest) {
        Member member = Member.builder()
                .firstName(userRegistrationRequest.firstName())
                .lastName(userRegistrationRequest.lastName())
                .email(userRegistrationRequest.email())
                .build();

        // TODO: Validation Using Vetting
        // This saves to database
        memberRepository.saveAndFlush(member);

        VettingResponse vettingResponse = vettingClient.isValid(member.getId());
        alertClient.sendAlert(
                new AlertRequest(
                        member.getId(),
                        member.getEmail(),
                        String.format("Hi %s, welcome to Khaled-Services...", member.getFirstName())
                )
        );

        if (!vettingResponse.isValid()) {
            throw new IllegalStateException("Did not pass the Vetting Process");
        }


    }
}
