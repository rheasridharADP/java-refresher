package com.webage.domain;

public class Money implements Comparable<Money> {
	int dollars;
	int cents;
	String currencySymbol;

	public Money(int dollars, int cents, String currencySymbol) {
		this.dollars = dollars;
		this.cents = cents;
		this.currencySymbol = currencySymbol;
	}

	public int compareTo(Money other) {
		if (this.currencySymbol.equals(other.currencySymbol) == false) {
			throw new IllegalArgumentException("Cannot compare "
					+ this.currencySymbol + " with " + other.currencySymbol
					+ ".");
		}
		int difference = (this.dollars * 100 + this.cents)
				- (other.dollars * 100 + other.cents);
		return difference;
	}

	public boolean equals(Object other) {
		if (other != null && other instanceof Money) {
			Money that = (Money) other;
			return (this.compareTo(that) == 0);
		} else {
			return false;
		}
	}

	public String toString() {
		String centsAsString;
		if (cents < 10) {
			centsAsString = "0" + cents;
		} else {
			centsAsString = String.valueOf(cents);
		}
		return currencySymbol + " " + dollars + "." + centsAsString;
	}

}
