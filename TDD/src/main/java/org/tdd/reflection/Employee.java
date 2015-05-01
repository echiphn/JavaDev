package org.tdd.reflection;

class Employee extends People {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String position;

	String getPosition() {
		return position;
	}

	void setPosition(String position) {
		this.position = position;
	}

}