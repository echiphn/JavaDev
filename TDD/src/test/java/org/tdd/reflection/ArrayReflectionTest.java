package org.tdd.reflection;

import static org.junit.Assert.*;

import java.lang.reflect.Array;

import org.junit.Test;

public class ArrayReflectionTest {

	@Test
	public void testInstantiateIntArray() {
		int[] intArray=(int[]) Array.newInstance(int.class, 3);
		Array.set(intArray, 0, 100);
		Array.set(intArray, 1, 1);
		Array.set(intArray, 2, 2);
		assertEquals(100,intArray[0]);
		assertEquals(1,intArray[1]);
		assertEquals(2,intArray[2]);
	}

}
