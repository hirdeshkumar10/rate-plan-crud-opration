package com.sunglowsys.service;

import com.sunglowsys.domain.RatePlan;
import com.sunglowsys.repository.RatePlanRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RatePlanServiceImpl implements RatePlanService{

    private final Logger log = LoggerFactory.getLogger(RatePlan.class);

    private final RatePlanRepository ratePlanRepository;

    public RatePlanServiceImpl(RatePlanRepository ratePlanRepository) {
        this.ratePlanRepository = ratePlanRepository;
    }

    @Override
    public RatePlan create(RatePlan ratePlan) {
        log.debug("Request to save RatePlan: {}",ratePlan);
        return ratePlanRepository.save(ratePlan);
    }

    @Override
    public RatePlan update(RatePlan ratePlan) {
        log.debug("Request to update RatePlan: {}",ratePlan);
        return ratePlanRepository.save(ratePlan);
    }

    @Override
    public Optional<RatePlan> findById(Long id) {
        log.debug("Request to findById RatePlan: {}",id);
        return ratePlanRepository.findById(id);
    }

    @Override
    public Page<RatePlan> findAll(Pageable pageable) {
        log.debug("Request to save RatePlan: {}",pageable.toString());
        return ratePlanRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to save RatePlan: {}",id);
        ratePlanRepository.deleteById(id);

    }
}
