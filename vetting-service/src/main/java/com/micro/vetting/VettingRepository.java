package com.micro.vetting;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VettingRepository extends JpaRepository<VettingCheck, Integer> {

}
