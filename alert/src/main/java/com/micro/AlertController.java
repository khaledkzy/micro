package com.micro;

import com.micro.clients.alert.AlertRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/alert")
@AllArgsConstructor
@Slf4j
public class AlertController {
        private final AlertService alertService;

    @PostMapping
    public void sendNotification(@RequestBody AlertRequest alertRequest) {
        log.info("Alert... {}", alertRequest);
        alertService.sendAlert(alertRequest);
    }
}
