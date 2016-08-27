package com.github.sql.builder.aggregate;

import com.github.sql.builder.model.Column;
import com.github.sql.builder.model.Table;

/**
 * Represents the <code>min</code> aggregate function.
 * 
 * @author Medhi
 *
 */
public class Min extends AbstractAggregate {

	/**
	 * Constructor of {@link Min}.
	 * 
	 * @param table
	 *            the {@link Table}
	 * @param columnName
	 *            the column name
	 */
	public Min(Table table, String columnName) {
		super(table, columnName);
	}

	/**
	 * Constructor of {@link Min}.
	 * 
	 * @param column
	 *            the {@link Column}
	 */
	public Min(Column column) {
		super(column);
	}

	@Override
	public String getFunction() {
		return "min";
	}

}
