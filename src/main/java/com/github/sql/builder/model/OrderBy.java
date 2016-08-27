package com.github.sql.builder.model;

import com.github.sql.builder.internal.Outputable;

/**
 * Represents an SQL order by clause.
 * 
 * @author Medhi
 *
 */
public class OrderBy implements Outputable {

	/**
	 * The column to sort.
	 */
	private final Column column;

	/**
	 * The sort type.
	 */
	private final boolean descending;

	/**
	 * Constructor of {@link OrderBy}.
	 * 
	 * @param column
	 *            the {@link Column}
	 * @param descending
	 *            the order type
	 */
	public OrderBy(Column column, boolean descending) {
		this.column = column;
		this.descending = descending;
	}

	public Column getColumn() {
		return column;
	}

	public boolean isDescending() {
		return descending;
	}

	@Override
	public void output(StringBuilder builder) {
		column.output(builder);

		builder.append(" ").append(descending ? "desc" : "asc");
	}

}
