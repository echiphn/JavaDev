package org.tdd;

/**
 * Example of DESIGN BY CONTRACT
 * 
 * @author cle
 * 
 */
public class Rate {
	private static final int MAX_RATE = 100;
	private int rate;

	public void changeCalculatedRate(int rate) {
		int newRate = rate * 2;
		setCalculatedRate(newRate);
	}

	/**
	 * assert enable? -ea or -enableassertions in VM arguments
	 * 
	 * @param newRate
	 */
	private void setCalculatedRate(int newRate) {
		// preconditions
		assert (newRate > 0 && newRate < MAX_RATE) : newRate;
		System.out.println("set calculated Rate");
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

}
