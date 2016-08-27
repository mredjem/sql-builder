package com.github.sql.builder.parameter;

import com.github.sql.builder.model.Column;

/**
 * Represents an SQL prepared statement anonymous parameter.
 * 
 * @author Medhi
 *
 */
public class AnonymousParameter implements Parameter {

	/**
	 * The parameter column.
	 */
	private final Column column;

	/**
	 * Constructor of {@link AnonymousParameter}.
	 * 
	 * @param column
	 *            the {@link Column}
	 */
	public AnonymousParameter(Column column) {
		this.column = column;
	}

	@Override
	public void output(StringBuilder builder) {
		column.output(builder);
		builder.append(" = ?");
	}

}
