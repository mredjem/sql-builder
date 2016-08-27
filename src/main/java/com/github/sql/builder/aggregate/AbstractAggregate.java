package com.github.sql.builder.aggregate;

import com.github.sql.builder.model.Column;
import com.github.sql.builder.model.Table;

/**
 * Abstract SQL aggregate function.
 * 
 * @author Medhi
 *
 */
public abstract class AbstractAggregate implements Aggregate {

	/**
	 * The column to aggregate.
	 */
	protected final Column column;

	/**
	 * Constructor of {@link AbstractAggregate}.
	 * 
	 * @param table
	 *            the {@link Table}
	 * @param columnName
	 *            the column name
	 */
	public AbstractAggregate(Table table, String columnName) {
		this(table.getColumn(columnName));
	}

	/**
	 * Constructor of {@link AbstractAggregate}.
	 * 
	 * @param column
	 *            the {@link Column}
	 */
	public AbstractAggregate(Column column) {
		this.column = column;
	}

	@Override
	public Column getColumn() {
		return column;
	}

	@Override
	public void output(StringBuilder builder) {
		builder.append(" ").append(getFunction()).append("(");
		column.output(builder);
		builder.append(")");
	}

}
