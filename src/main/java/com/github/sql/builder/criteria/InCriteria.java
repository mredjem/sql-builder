package com.github.sql.builder.criteria;

import com.github.sql.builder.model.Column;
import com.github.sql.builder.model.Table;
import com.github.sql.builder.model.Value;

/**
 * Represents a <code>in</code> predicate.
 * 
 * @author Medhi
 *
 */
public class InCriteria implements Criteria {

	/**
	 * The column to apply the predicate to.
	 */
	private final Column column;

	/**
	 * The valid values.
	 */
	private Value[] values;

	/**
	 * Constructor of {@link InCriteria}.
	 * 
	 * @param table
	 *            the {@link Table}
	 * @param columnName
	 *            the column name
	 * @param values
	 *            the {@link Value}
	 */
	public InCriteria(Table table, String columnName, Value... values) {
		this(table.getColumn(columnName));
		this.values = values;
	}

	/**
	 * Constructor of {@link InCriteria}.
	 * 
	 * @param column
	 *            the {@link Column}
	 * @param values
	 *            the {@link Value}
	 */
	public InCriteria(Column column, Value... values) {
		this.column = column;
		this.values = values;
	}

	@Override
	public void output(StringBuilder builder) {
		column.output(builder);
		builder.append(" in (");

		for (int i = 0; i < values.length; i++) {
			Value value = values[i];
			value.output(builder);

			if (i < values.length - 1) {
				builder.append(", ");
			}
		}

		builder.append(")");
	}

}
