package org.tdd.framework.hamcrest;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsNotANumber extends TypeSafeMatcher<Double> {

	public void describeTo(Description description) {
		description.appendText("not a number");
	}

	@Override
	protected boolean matchesSafely(Double number) {
		return number.isNaN();
	}

	@Factory
	public static <T> Matcher<Double> notANumber() {
		return new IsNotANumber();
	}

}
