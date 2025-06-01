package com.cloudsub.subscription_service.client;

import com.cloudsub.subscription_service.Dto.PlanDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "plan-service")
public interface PlanClient {
    @GetMapping("/api/plans/{id}")
    PlanDto getPlanById(@PathVariable("id") Long id);
}
