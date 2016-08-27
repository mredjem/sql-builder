package com.github.sql.builder.parameter;

import com.github.sql.builder.model.Column;

/**
 * Represents an SQL prepared statement named parameter.
 * 
 * @author Medhi
 *
 */
public class NamedParameter implements Parameter {

	/**
	 * The parameter column.
	 */
	private final Column column;

	/**
	 * The named parameter name.
	 */
	private final String name;

	/**
	 * Constructor of {@link NamedParameter}.
	 * 
	 * @param column
	 *            the {@link Column}
	 * @param name
	 *            the parameter name
	 */
	public NamedParameter(Column column, String name) {
		this.column = column;
		this.name = name;
	}

	@Override
	public void output(StringBuilder builder) {
		column.output(builder);
		builder.append(" = :").append(name);
	}

}
