package com.github.sql.builder.aggregate;

import com.github.sql.builder.model.Column;
import com.github.sql.builder.model.Table;

/**
 * Represents the <code>max</code> aggregate function.
 * 
 * @author Medhi
 *
 */
public class Max extends AbstractAggregate {

	/**
	 * Constructor of {@link Max}.
	 * 
	 * @param table
	 *            the {@link Table}
	 * @param columnName
	 *            the column name
	 */
	public Max(Table table, String columnName) {
		super(table, columnName);
	}

	/**
	 * Constructor of {@link Max}.
	 * 
	 * @param column
	 *            the {@link Column}
	 */
	public Max(Column column) {
		super(column);
	}

	@Override
	public String getFunction() {
		return "max";
	}

}
