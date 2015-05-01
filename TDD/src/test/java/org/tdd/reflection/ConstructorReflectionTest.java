package org.tdd.reflection;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConstructorReflectionTest {
	
	@Test
	public void testConstructor() throws ClassNotFoundException {
		Class claz = Class.forName("org.tdd.reflection.Employee");
		Constructor[] constructor = claz.getConstructors();
		assertEquals(0,constructor.length);
		Class peopleClaz=Class.forName("org.tdd.reflection.People");
		Constructor[] peopleConstructors = peopleClaz.getConstructors();
		assertEquals(2,peopleConstructors.length);
	}
	@Test
	public void testConstructorParameters() throws ClassNotFoundException{
		Class peopleClaz=Class.forName("org.tdd.reflection.People");
		Constructor[] peopleConstructors = peopleClaz.getConstructors();
		Class[] params_firstConstructor = peopleConstructors[0].getParameterTypes();
		assertEquals(1,params_firstConstructor.length);
		assertEquals(String.class,params_firstConstructor[0]);
		Class[] params_secondConstructor = peopleConstructors[1].getParameterTypes();
		assertEquals("a constructor without param",0,params_secondConstructor.length);
	}
	
	@Test(expected=NoSuchMethodException.class)
	public void testConstructorParameters_Notfound() throws ClassNotFoundException, NoSuchMethodException, SecurityException{
		Class peopleClaz=Class.forName("org.tdd.reflection.People");
		Constructor constructor_WithoutParam = peopleClaz.getConstructor();
		assertNotNull("there is a constructor without parameter",constructor_WithoutParam);
		peopleClaz.getConstructor(Double.class);
	}
	
}
