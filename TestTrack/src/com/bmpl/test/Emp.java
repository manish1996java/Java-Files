package com.bmpl.test;

import java.io.Serializable;

class Emp implements Serializable{
	
	private int empId = 102;
	private int salary = 2000;
	private String empName ="vijay";
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
