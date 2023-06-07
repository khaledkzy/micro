package com.micro.vetting;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VettingService {

    // Mock that we actually Validated the member
    private final VettingRepository vettingRepository;

    public VettingService(VettingRepository vettingRepository) {
        this.vettingRepository = vettingRepository;
    }

    public boolean passedVettingCheck(Integer memberId) {
        // Store in the database
        vettingRepository.save(
                VettingCheck
                        .builder()
                        .memberId(memberId)
                        .isValid(true)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        // Assume that they Passed
        return true;
    }
}
