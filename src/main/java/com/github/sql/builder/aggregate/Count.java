package com.github.sql.builder.aggregate;

import com.github.sql.builder.model.Column;
import com.github.sql.builder.model.Table;

/**
 * Represents the <code>count</code> aggregate function.
 * 
 * @author Medhi
 *
 */
public class Count extends AbstractAggregate {

	/**
	 * Constructor of {@link Count}.
	 * 
	 * @param table
	 *            the {@link Table}
	 * @param columnName
	 *            the column name
	 */
	public Count(Table table, String columnName) {
		super(table, columnName);
	}

	/**
	 * Constructor of {@link Count}.
	 * 
	 * @param column
	 *            the {@link Column}
	 */
	public Count(Column column) {
		super(column);
	}

	@Override
	public String getFunction() {
		return "count";
	}

}
