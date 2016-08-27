package com.github.sql.builder.aggregate;

import com.github.sql.builder.model.Column;
import com.github.sql.builder.model.Table;

/**
 * Represents the <code>avg</code> aggregate function.
 * 
 * @author Medhi
 *
 */
public class Avg extends AbstractAggregate {

	/**
	 * Constructor of {@link Avg}.
	 * 
	 * @param table
	 *            the {@link Table}
	 * @param columnName
	 *            the column name
	 */
	public Avg(Table table, String columnName) {
		super(table, columnName);
	}

	/**
	 * Constructor of {@link Avg}.
	 * 
	 * @param column
	 *            the {@link Column}
	 */
	public Avg(Column column) {
		super(column);
	}

	@Override
	public String getFunction() {
		return "avg";
	}

}
