package org.tdd.reflection;

import static org.junit.Assert.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.junit.Test;

public class AnnotationReflectionTest {

	@Test
	public void testGetAnnotationInfo() {
		Class claz = ClassUseAnnotation.class;
		Annotation[] annotations = claz.getAnnotations();
		for (Annotation ano : annotations) {
			if (ano instanceof MyClassAnnotation) {
				assertEquals("class", ((MyClassAnnotation) ano).name());
				assertEquals("Annotation", ((MyClassAnnotation) ano).value());
			}
		}
	}

	/**
	 *  get directly a specific annotation
	 */
	@Test
	public void testGetDirectSpecificAnnotation() {
		Class claz = ClassUseAnnotation.class;
		Annotation ano = claz.getAnnotation(MyClassAnnotation.class);
		assertTrue(ano instanceof MyClassAnnotation);
		assertEquals("class", ((MyClassAnnotation) ano).name());
		assertEquals("Annotation", ((MyClassAnnotation) ano).value());
	}

	
	@Test
	public void testGetMethodAnnotation() throws NoSuchMethodException, SecurityException {
		Class claz = ClassUseAnnotation.class;
		Method m=claz.getDeclaredMethod("sayHello");
		Annotation methodAnnotation=m.getAnnotation(MyMethodAnnotation.class);
		assertTrue(methodAnnotation instanceof MyMethodAnnotation);
		assertEquals("mark", ((MyMethodAnnotation)methodAnnotation).mark());
		assertFalse(((MyMethodAnnotation)methodAnnotation).runtime());
	}
}
