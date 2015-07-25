package org.tdd.reflection;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConstructorReflectionTest {
	private Class claz;

	@Before
	public void setUp() throws ClassNotFoundException {
		claz = Class.forName("org.tdd.reflection.People");
	}

	@After
	public void tearDown() {
		claz = null;
	}

	@Test
	public void testConstructor() throws ClassNotFoundException {
		Class employeeClaz = Class.forName("org.tdd.reflection.Employee");
		Constructor[] constructor = employeeClaz.getConstructors();
		assertEquals(1, constructor.length);
		Constructor[] peopleConstructors = claz.getConstructors();
		assertEquals(2, peopleConstructors.length);
	}

	@Test
	public void testConstructorParameters() throws ClassNotFoundException {
		Constructor[] peopleConstructors = claz.getConstructors();
		Class[] params_firstConstructor = peopleConstructors[0]
				.getParameterTypes();
		assertEquals(1, params_firstConstructor.length);
		assertEquals(String.class, params_firstConstructor[0]);
		Class[] params_secondConstructor = peopleConstructors[1]
				.getParameterTypes();
		assertEquals("a constructor without param", 0,
				params_secondConstructor.length);
	}

	@Test(expected = NoSuchMethodException.class)
	public void testConstructorParameters_Notfound()
			throws ClassNotFoundException, NoSuchMethodException,
			SecurityException {
		Constructor constructor_WithoutParam = claz.getConstructor();
		assertNotNull("there is a constructor without parameter",
				constructor_WithoutParam);
		claz.getConstructor(Double.class);
	}

	@Test
	public void testInstantiatingObject() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<People> constructor = claz.getConstructor(String.class);
		assertNotNull("constructor with string parameter exist",constructor);
		People p=constructor.newInstance("Testname");
		assertEquals("Testname",p.getName());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInstantiatingObject_IllegalArg() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<People> constructor = claz.getConstructor(String.class);
		assertNotNull("constructor with string parameter exist",constructor);
		constructor.newInstance(new Double(10.0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInstantiatingObject_NoArgExpected() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<People> constructor = claz.getConstructor();
		assertNotNull("constructor with string parameter exist",constructor);
		constructor.newInstance("test");
	}
	
	/**
	 * the private constructor of Employee can not be accessed
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws ClassNotFoundException
	 */
	@Test(expected=NoSuchMethodException.class)
	public void testInstantiatingObject_NotAccessablConstructor()
			throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			ClassNotFoundException {
		Class employeeClaz=Class.forName("org.tdd.reflection.Employee");
		employeeClaz.getConstructor(BigDecimal.class);
	}
}
