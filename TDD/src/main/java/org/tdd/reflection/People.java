package org.tdd.reflection;

import java.io.Serializable;

class People implements Cloneable,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

}