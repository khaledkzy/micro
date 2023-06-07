package com.micro;


import com.micro.clients.alert.AlertRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AlertService {
    private final AlertRepo alertRepo;
    public void sendAlert(AlertRequest alertRequest) {
        alertRepo.save(
                Alert.builder()
                        .toMemberId(alertRequest.toMemberId())
                        .toMemberEmail(alertRequest.toMemberName())
                        .sender("khaled")
                        .message(alertRequest.alertText())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}
