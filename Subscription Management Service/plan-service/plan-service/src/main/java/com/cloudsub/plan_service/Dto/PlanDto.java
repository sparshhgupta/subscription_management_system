package com.cloudsub.plan_service.Dto;

import lombok.Data;

@Data
public class PlanDto {
	private Long id;
    private String name;
    private String description;
    private Double price;
    private String duration;
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public PlanDto() {
		
	}
	public PlanDto(Long id, String name, String description, Double price, String duration) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.duration = duration;
	}
//	public PlanDto(String name, String description, Double price, String duration) {
//		super();
//		this.name = name;
//		this.description = description;
//		this.price = price;
//		this.duration = duration;
//	}
	
    
    
}
