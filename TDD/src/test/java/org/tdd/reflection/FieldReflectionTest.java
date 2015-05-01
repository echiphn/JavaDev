package org.tdd.reflection;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;

public class FieldReflectionTest {

	@Test(expected = NoSuchFieldException.class)
	public void testGetPrivateField() throws NoSuchFieldException,
			SecurityException {
		Class claz = Employee.class;
		claz.getField("position");
	}

	@Test
	public void testAccessPrivateField() throws NoSuchFieldException,
			SecurityException, InstantiationException, IllegalAccessException {
		Class claz = Employee.class;
		Field positionField = claz.getDeclaredField("position");
		assertNotNull(positionField);
		positionField.setAccessible(true);
		Employee employee = new Employee();
		employee.setPosition("Manager");
		assertEquals("Manager", positionField.get(employee));
	}

}
