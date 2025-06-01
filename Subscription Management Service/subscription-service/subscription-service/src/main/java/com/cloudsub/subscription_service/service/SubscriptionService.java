package com.cloudsub.subscription_service.service;

import com.cloudsub.subscription_service.Dto.SubscriptionDto;
import java.util.List;

public interface SubscriptionService {
    SubscriptionDto createSubscription(SubscriptionDto dto);
    List<SubscriptionDto> getAllSubscriptions();
}
