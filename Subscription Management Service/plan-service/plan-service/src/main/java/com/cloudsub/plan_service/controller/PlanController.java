package com.cloudsub.plan_service.controller;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudsub.plan_service.Dto.PlanDto;
import com.cloudsub.plan_service.service.PlanService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/plans")
@RequiredArgsConstructor
public class PlanController {
	@Autowired
	private PlanService planService;
	@GetMapping("/")
	public List<PlanDto> fetchAllPlans(){
		return planService.getAllPlans();
	}
	@PostMapping("/")
	public PlanDto addPlan(@RequestBody PlanDto newPlan) {
		return planService.createPlan(newPlan);
	}
	@GetMapping("/{id}")
    public PlanDto getPlanById(@PathVariable Integer id) {
        return planService.getPlanById(id);
    }
	@DeleteMapping("/{id}")
	public String deletePlan(@PathVariable Integer id) {
		planService.deletePlan(id);
		return "success";
	}
}
