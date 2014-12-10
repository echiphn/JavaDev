package org.tdd;

import org.junit.Test;

public class RateTest {

	@Test(expected = AssertionError.class)
	public void testChangeCalculatedRate() {
		Rate rate = new Rate();
		rate.changeCalculatedRate(-1);
	}

}
