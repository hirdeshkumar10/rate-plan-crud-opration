package com.sunglowsys.service;

import com.sunglowsys.domain.RatePlan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RatePlanService {

    RatePlan create(RatePlan ratePlan);

    RatePlan update(RatePlan ratePlan);

    Optional<RatePlan> findById(Long id);

    Page<RatePlan> findAll(Pageable pageable);

    void delete(Long id);
}
