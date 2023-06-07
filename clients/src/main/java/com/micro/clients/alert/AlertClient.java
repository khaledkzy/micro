package com.micro.clients.alert;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("alert")
public interface AlertClient {
    @PostMapping("api/alert")
    void sendAlert(AlertRequest alertRequest);
}
