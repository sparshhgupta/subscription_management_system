package com.cloudsub.subscription_service.service;

import com.cloudsub.subscription_service.client.PlanClient;
import com.cloudsub.subscription_service.client.UserClient;
import com.cloudsub.subscription_service.Dto.SubscriptionDto;
import com.cloudsub.subscription_service.model.Subscription;
import com.cloudsub.subscription_service.Repository.SubscriptionRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired private SubscriptionRepository repository;
    @Autowired private UserClient userClient;
    @Autowired private PlanClient planClient;

    @Override
    public SubscriptionDto createSubscription(SubscriptionDto dto) {
        // Check user exists
        try {
            userClient.getUserById(dto.getUserId());
        } catch (FeignException.NotFound e) {
            throw new RuntimeException("User not found");
        }

        // Check plan exists
        try {
            planClient.getPlanById(dto.getPlanId());
        } catch (FeignException.NotFound e) {
            throw new RuntimeException("Plan not found");
        }

        Subscription sub = new Subscription(null, dto.getUserId(), dto.getPlanId(), dto.getStartDate());
        Subscription saved = repository.save(sub);

        return new SubscriptionDto(saved.getId(), saved.getUserId(), saved.getPlanId(), saved.getStartDate());
    }

    @Override
    public List<SubscriptionDto> getAllSubscriptions() {
        return repository.findAll().stream()
                .map(s -> new SubscriptionDto(s.getId(), s.getUserId(), s.getPlanId(), s.getStartDate()))
                .collect(Collectors.toList());
    }
}
