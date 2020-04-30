package bll.validators;

/**
 * Input data validator
 */
public interface Validator<T> {

	public void validate(T t);
}
