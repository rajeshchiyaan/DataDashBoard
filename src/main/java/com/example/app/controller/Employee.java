package com.example.app.controller;

public class Employee {

	private String name;
	private String location;
	private String skillSet;
	private String tFactor;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getSkillSet() {
		return skillSet;
	}
	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}
	
	public String gettFactor() {
		return tFactor;
	}
	public void settFactor(String tFactor) {
		this.tFactor = tFactor;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", location=" + location + ", skillSet=" + skillSet + ", tFactor=" + tFactor
				+ "]";
	}
	
}
