package com.sunglowsys.service;

import com.sunglowsys.domain.RatePlan;

import java.util.List;
import java.util.Optional;

public interface RatePlanService {

    RatePlan create(RatePlan ratePlan);

    RatePlan update(RatePlan ratePlan);

    Optional<RatePlan> findById(Long id);

    List<RatePlan> findAll();

    void delete(Long id);
}
