package org.tdd.reflection;

import java.math.BigDecimal;

class Employee extends People {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String position;
	private BigDecimal salary;
	
	private Employee(BigDecimal salary) {
		super();
		this.salary = salary;
	}

	BigDecimal getSalary() {
		return salary;
	}

	void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	String getPosition() {
		return position;
	}

	void setPosition(String position) {
		this.position = position;
	}

}