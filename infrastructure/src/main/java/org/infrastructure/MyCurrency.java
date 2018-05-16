package org.infrastructure;

import org.domain.Currency;

public class MyCurrency implements Currency {

	private String amount;

	public MyCurrency(String amount) {
		this.amount = amount;
	}

}
