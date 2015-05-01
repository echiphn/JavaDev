package org.tdd.reflection;

import java.io.Serializable;

class People implements Cloneable,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	public People(String name) {
		super();
		this.name = name;
	}

	public People() {
		super();
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

}