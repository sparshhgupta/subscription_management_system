package com.cloudsub.subscription_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cloudsub.subscription_service.model.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
	
}
