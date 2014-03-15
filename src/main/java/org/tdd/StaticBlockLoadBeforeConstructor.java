package org.tdd;

public class StaticBlockLoadBeforeConstructor {
	static boolean initialized = false;
	static final int A = 5;
	static final int B; // note that it is not Æ public static final int
						// B = null;
	// note that since B is final, it can be initialized only once.
	// Static initializer block, which is executed only once when the class is
	// loaded.
	static {
		B = 10;
	}

	public StaticBlockLoadBeforeConstructor() {
		initialized = true;
	}

}
