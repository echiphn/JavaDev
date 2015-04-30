package org.tdd.reflection;

import static org.junit.Assert.*;

import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BasicReflectionTest {
	private Class claz;

	@Before
	public void setUp() throws ClassNotFoundException {
		claz = Class.forName("org.tdd.reflection.Employee");
	}

	@After
	public void tearDown() {
		claz = null;
	}

	@Test
	public void testClassName() {
		assertEquals("Employee", claz.getSimpleName());
		assertEquals("org.tdd.reflection.Employee", claz.getName());
	}

	@Test
	public void testModifier() {
		int modifiers = claz.getModifiers();
		assertFalse(Modifier.isAbstract(modifiers));
		assertFalse(Modifier.isPublic(modifiers));
		assertFalse(Modifier.isPrivate(modifiers));
		assertFalse(Modifier.isProtected(modifiers));
	}

	@Test
	public void testPackageInfo() {
		Package pkg = claz.getPackage();
		assertNull(pkg.getImplementationVendor());
		assertEquals("org.tdd.reflection", pkg.getName());
	}

	@Test
	public void testSuperClass() {
		Class superClass = claz.getSuperclass();
		assertEquals("org.tdd.reflection.People", superClass.getName());
	}

	@Test
	public void testInterface() {
		Class superClass = claz.getSuperclass();
		Class[] interfaces = superClass.getInterfaces();
		assertEquals(2, interfaces.length);
		assertEquals("java.lang.Cloneable", interfaces[0].getName());
		assertEquals("java.io.Serializable", interfaces[1].getName());
	}

}
