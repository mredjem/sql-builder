package com.github.sql.builder.criteria;

import com.github.sql.builder.model.Column;
import com.github.sql.builder.model.Table;

/**
 * Represents a <code>is not null</code> predicate.
 * 
 * @author Medhi
 *
 */
public class IsNotNullCriteria implements Criteria {

	/**
	 * The column to apply the predicate to.
	 */
	private final Column column;

	/**
	 * Constructor of {@link IsNotNullCriteria}.
	 * 
	 * @param table
	 *            the {@link Table}
	 * @param columnName
	 *            the column name
	 */
	public IsNotNullCriteria(Table table, String columnName) {
		this(table.getColumn(columnName));
	}

	/**
	 * Constructor of {@link IsNotNullCriteria}.
	 * 
	 * @param column
	 *            the {@link Column}
	 */
	public IsNotNullCriteria(Column column) {
		this.column = column;
	}

	@Override
	public void output(StringBuilder builder) {
		column.output(builder);
		builder.append(" is not null");
	}

}
