package com.github.sql.builder.aggregate;

import com.github.sql.builder.model.Column;
import com.github.sql.builder.model.Table;

/**
 * Represents the <code>sum</code> aggregate function.
 * 
 * @author Medhi
 *
 */
public class Sum extends AbstractAggregate {

	/**
	 * Constructor of {@link Sum}.
	 * 
	 * @param table
	 *            the {@link Table}
	 * @param columnName
	 *            the column name
	 */
	public Sum(Table table, String columnName) {
		super(table, columnName);
	}

	/**
	 * Constructor of {@link Sum}.
	 * 
	 * @param column
	 *            the {@link Column}
	 */
	public Sum(Column column) {
		super(column);
	}

	@Override
	public String getFunction() {
		return "sum";
	}

}
