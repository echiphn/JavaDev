package org.tdd.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

public class ConcurrentModificationTest {

	@Test
	public void test() {
		final String toRemove = "456";
		Collection<String> myCollection = new ArrayList<String>(10);
		myCollection.add("123");
		myCollection.add("456");
		myCollection.add("789");
		for (Iterator it = myCollection.iterator(); it.hasNext();) {
			String myObject = (String) it.next();
			if (toRemove.equals(myObject)) {
				myCollection.remove(myObject); // can throw
												// ConcurrentModificationException
												// in single as
				// well as multi-thread access situations.
			}
		}
	}

}
