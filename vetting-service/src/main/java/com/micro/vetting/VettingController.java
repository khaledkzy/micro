package com.micro.vetting;


import com.micro.clients.vetting.VettingResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/vetting")
public class VettingController {
    private final VettingService vettingService;

    public VettingController(VettingService vettingService) {
        this.vettingService = vettingService;
    }
    @GetMapping(path = "{memberId}")
    public VettingResponse isValid(@PathVariable("memberId") Integer memberId) {

        boolean isValid = vettingService.passedVettingCheck(memberId);
        log.info("memberId {}", memberId);
        return new VettingResponse(isValid);
    }
}