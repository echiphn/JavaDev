package org.tdd.reflection;

class Employee extends People {
	private String position;

	String getPosition() {
		return position;
	}

	void setPosition(String position) {
		this.position = position;
	}

}