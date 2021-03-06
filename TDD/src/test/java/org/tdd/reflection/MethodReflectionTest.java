package org.tdd.reflection;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.SetUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MethodReflectionTest {
	private Class claz;

	@Before
	public void setUp() throws ClassNotFoundException {
		claz = Employee.class;
	}

	@After
	public void tearDown() {
		claz = null;
	}

	@Test
	public void testGetPublicMethods() {
		Method[] publicMethods = claz.getMethods();
		List<String> publicMethodNames = new ArrayList<>();
		for (Method m : publicMethods) {
			publicMethodNames.add(m.getName());
		}
		List<String> expectedPublicMethodNames = new ArrayList<>();
		expectedPublicMethodNames.addAll(Arrays.asList("wait", "wait", "wait", "equals",
				"toString", "hashCode", "getClass", "notify", "notifyAll"));
		expectedPublicMethodNames.add("work");
		SetUtils.isEqualSet(expectedPublicMethodNames,
				publicMethodNames);
	}
	
	/**
	 * test declared not inherited methods
	 */
	@Test
	public void testGetDeclaredMethods() {
		Method[] declaredMethods = claz.getDeclaredMethods();
		List<String> declaredMethodNames = new ArrayList<>();
		for (Method m : declaredMethods) {
			declaredMethodNames.add(m.getName());
		}
		List<String> expectedPublicMethodNames = new ArrayList<>();
		expectedPublicMethodNames.addAll(Arrays.asList("getSalary", "setSalary", "getPosition", "setPosition",
				"work", "doPrivateWork"));
		SetUtils.isEqualSet(expectedPublicMethodNames,
				declaredMethodNames);
	}
	
	@Test
	public void testInvokeMethod() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		Class<People> claz=People.class;
		Method setNameMethod=claz.getDeclaredMethod("setName", String.class);
		People p = claz.newInstance();
		setNameMethod.invoke(p, "testName");
		assertEquals("testName",p.getName());
	}
	
	@Test
	public void testInvokeStaticMethod() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		Class<Utility> claz=Utility.class;
		Method setNameMethod=claz.getDeclaredMethod("getApplicationName");
		assertEquals("Test Application",setNameMethod.invoke(null));
	}
	
	
	@Test(expected=IllegalAccessException.class)
	public void testInvokePrivateMethodFailed() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method privateMethod = claz.getDeclaredMethod("doPrivateWork");
		privateMethod.invoke(new Employee());
	}
	
	@Test
	public void testInvokePrivateMethod() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method privateMethod = claz.getDeclaredMethod("doPrivateWork");
		privateMethod.setAccessible(true);
		Object voidReturn = privateMethod.invoke(new Employee());
		assertNull(voidReturn);
	}
}
