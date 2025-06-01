package com.cloudsub.plan_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudsub.plan_service.model.plan;

public interface PlanRepository extends JpaRepository<plan,Integer>{

}
