package org.tdd.reflection;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;

public class FieldReflectionTest {

	@Test(expected=NoSuchFieldException.class)
	public void testGetPrivateField() throws NoSuchFieldException, SecurityException {
		Class claz=Employee.class;
		claz.getField("position");
	}

}
