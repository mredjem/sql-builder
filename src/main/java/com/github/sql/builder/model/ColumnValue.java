package com.github.sql.builder.model;

import com.github.sql.builder.criteria.Criteria;
import com.github.sql.builder.criteria.MatchCriteria;
import com.github.sql.builder.internal.Outputable;

/**
 * Represent a couple of a {@link Column} and its associated {@link Value}.
 * 
 * @author Medhi
 *
 */
public class ColumnValue implements Outputable {

	/**
	 * The column.
	 */
	private final Column column;

	/**
	 * The associated value.
	 */
	private final Value value;

	public ColumnValue(Column column, Value value) {
		this.column = column;
		this.value = value;
	}

	/**
	 * Returns the associated {@link Column}.
	 * 
	 * @return a {@link Column}
	 */
	public Column getColumn() {
		return column;
	}

	/**
	 * Returns the associated {@link Value}.
	 * 
	 * @return a {@link Value}
	 */
	public Value getValue() {
		return value;
	}

	@Override
	public void output(StringBuilder builder) {
		Criteria criteria = new MatchCriteria(column, value);
		criteria.output(builder);
	}

}
