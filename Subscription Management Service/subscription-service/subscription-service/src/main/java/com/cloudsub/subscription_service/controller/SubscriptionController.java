package com.cloudsub.subscription_service.controller;

import com.cloudsub.subscription_service.Dto.SubscriptionDto;
import com.cloudsub.subscription_service.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping("/")
    public SubscriptionDto create(@RequestBody SubscriptionDto dto) {
        return subscriptionService.createSubscription(dto);
    }

    @GetMapping("/")
    public List<SubscriptionDto> getAll() {
        return subscriptionService.getAllSubscriptions();
    }
}
