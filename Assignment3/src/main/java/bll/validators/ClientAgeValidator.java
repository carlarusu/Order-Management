package bll.validators;

import model.TClient;

/**
 * Input data validator (age)
 */
public class ClientAgeValidator implements Validator<TClient> {
	private static final int MIN_AGE = 18;
	private static final int MAX_AGE = 100;

	public void validate(TClient t) {

		if (t.getAge() < MIN_AGE || t.getAge() > MAX_AGE) {
			throw new IllegalArgumentException("The Student Age limit is not respected!");
		}

	}

}
