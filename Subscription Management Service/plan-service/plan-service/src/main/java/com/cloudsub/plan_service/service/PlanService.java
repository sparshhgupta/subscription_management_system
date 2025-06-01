package com.cloudsub.plan_service.service;

import java.util.*;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudsub.plan_service.Dto.PlanDto;
import com.cloudsub.plan_service.Repository.PlanRepository;
import com.cloudsub.plan_service.model.plan;

@Service
public class PlanService {
	@Autowired
	private PlanRepository planRepo;
	public List<PlanDto> getAllPlans(){
		List<plan> allPlans= planRepo.findAll();
		List<PlanDto> allPlanDtos=new ArrayList<PlanDto>();
		for(plan p: allPlans) {
			PlanDto tempPlanDto=new PlanDto(p.getId(),p.getName(),p.getDescription(),p.getPrice(),p.getDuration());
			allPlanDtos.add(tempPlanDto);
		}
		return allPlanDtos;
	}
	public PlanDto createPlan(PlanDto newPlan) {
		plan nPlan = new plan(newPlan.getId(),newPlan.getName(),newPlan.getDescription(),newPlan.getPrice(),newPlan.getDuration());
		planRepo.save(nPlan);
		return new PlanDto(nPlan.getId(),nPlan.getName(),nPlan.getDescription(),nPlan.getPrice(),nPlan.getDuration());
	}
	
	public PlanDto getPlanById(Integer id) {
        Optional<plan> planOpt = planRepo.findById(id);

        if (planOpt.isEmpty()) {
            throw new RuntimeException("Plan with ID " + id + " not found.");
        }

        plan plan = planOpt.get();
        return new PlanDto(plan.getId(), plan.getName(), plan.getDescription(), plan.getPrice(), plan.getDuration());
    }
	
	public void deletePlan(Integer id) {
		planRepo.deleteById(id);
    }
}
