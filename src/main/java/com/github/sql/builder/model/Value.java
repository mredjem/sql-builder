package com.github.sql.builder.model;

import com.github.sql.builder.internal.Outputable;
import com.github.sql.builder.util.StringUtils;

/**
 * Represent a SQL value.
 * 
 * @author Medhi
 *
 */
public class Value implements Outputable {

	/**
	 * The nested object.
	 */
	private final Object value;

	/**
	 * Constructor of {@link Value}.
	 * 
	 * @param value
	 *            the nested object
	 */
	public Value(Object value) {
		this.value = value;
	}

	/**
	 * Returns the nested object.
	 * 
	 * @return an object
	 */
	public Object getValue() {
		return value;
	}

	@Override
	public void output(StringBuilder builder) {
		if (value instanceof String) {
			builder.append(StringUtils.escapeSql((String) value));
		} else {
			builder.append(value);
		}
	}

}
