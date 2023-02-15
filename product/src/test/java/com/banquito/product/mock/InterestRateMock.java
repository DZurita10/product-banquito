package com.banquito.product.mock;

import com.banquito.product.product.model.InterestRate;

public class InterestRateMock {

	public InterestRate mockInterestRate(String id, String name, String type) {
		return InterestRate.builder().id(id).name(name).type(type).build();
	}

}
