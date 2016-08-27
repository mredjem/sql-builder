package com.github.sql.builder.criteria;

import com.github.sql.builder.model.Column;

/**
 * Represents a <code>is null</code> predicate.
 * 
 * @author Medhi
 *
 */
public class IsNullCriteria implements Criteria {

	/**
	 * The column to apply the predicate to.
	 */
	private final Column column;

	/**
	 * Constructor of {@link IsNullCriteria}.
	 * 
	 * @param column
	 *            the {@link Column}
	 */
	public IsNullCriteria(Column column) {
		this.column = column;
	}

	@Override
	public void output(StringBuilder builder) {
		column.output(builder);
		builder.append(" is null");
	}

}
