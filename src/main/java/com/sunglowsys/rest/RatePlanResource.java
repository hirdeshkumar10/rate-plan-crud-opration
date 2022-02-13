package com.sunglowsys.rest;

import com.sunglowsys.domain.RatePlan;
import com.sunglowsys.service.RatePlanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RatePlanResource {

    private final Logger log = LoggerFactory.getLogger(RatePlanResource.class);

    private final RatePlanService ratePlanService;

    public RatePlanResource(RatePlanService ratePlanService) {
        this.ratePlanService = ratePlanService;
    }
    @PostMapping("/rate-plans")
    public ResponseEntity<RatePlan> createRatePlan(@RequestBody RatePlan ratePlan)throws URISyntaxException{
        log.debug("rest request to save RatePlan: {}",ratePlan);
        if (ratePlan.getId() != null){
            throw new RuntimeException("Id should be null in create API calls");
        }
        RatePlan result = ratePlanService.create(ratePlan);
        return ResponseEntity
                .created(new URI("/api/rate-plans/"+result.getId()))
                .body(result);
    }

    @PutMapping("/rate-plans")
    public ResponseEntity<RatePlan> updateRatePlan(@RequestBody RatePlan ratePlan){
        log.debug("rest request to update RatePlan: {}",ratePlan);
        if (ratePlan.getId() == null){
            throw new RuntimeException("Id should not be null in update api calls ");
        }
        RatePlan result = ratePlanService.update(ratePlan);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/rate-plans")
    public ResponseEntity<List<RatePlan>> findAllRatePlan(){
        log.debug("rest request to findAll RatePlan:");
        List<RatePlan> result = ratePlanService.findAll();
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/rate-plans/{id}")
    public ResponseEntity<RatePlan> findByIdRatePlan(@PathVariable Long id){
        log.debug("rest request to findById RatePlan: {}",id);
        Optional<RatePlan> result = ratePlanService.findById(id);
        return ResponseEntity
                .ok()
                .body(result.get());
    }


    @DeleteMapping("/rate-plans/{id}")
    public ResponseEntity<Void> deleteRatePlan(@PathVariable Long id){
        log.debug("rest request to save RatePlan: {}",id);
        ratePlanService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
