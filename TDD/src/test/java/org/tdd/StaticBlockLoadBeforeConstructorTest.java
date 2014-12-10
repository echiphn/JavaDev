package org.tdd;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import org.junit.Test;

public class StaticBlockLoadBeforeConstructorTest {

	@Test
	public void test() {
		assertThat("The constructor is not called yet",
				StaticBlockLoadBeforeConstructor.initialized, not(true));
		assertThat(StaticBlockLoadBeforeConstructor.A, equalTo(5));
		assertThat(StaticBlockLoadBeforeConstructor.B, equalTo(10));
	}
}
