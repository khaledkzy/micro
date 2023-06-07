package com.micro.clients.vetting;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("Vetting-Service")

public interface VettingClient {
    @GetMapping(path = "api/vetting/{memberId}")
    VettingResponse isValid(@PathVariable("memberId") Integer memberId);
}
