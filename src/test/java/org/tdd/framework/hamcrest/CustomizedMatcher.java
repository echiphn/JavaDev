package org.tdd.framework.hamcrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.tdd.framework.hamcrest.IsNotANumber.notANumber;

import org.junit.Test;

public class CustomizedMatcher {

	@Test
	public void testSquareRootOfMinusOneIsNotANumber() {
		assertThat(Math.sqrt(-1), is(notANumber()));
	}

}
