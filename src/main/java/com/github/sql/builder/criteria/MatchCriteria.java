package com.github.sql.builder.criteria;

import com.github.sql.builder.aggregate.Aggregate;
import com.github.sql.builder.constants.Operator;
import com.github.sql.builder.model.Column;
import com.github.sql.builder.model.Table;
import com.github.sql.builder.model.Value;

/**
 * Represents a matching predicate.
 * 
 * @author Medhi
 *
 */
public class MatchCriteria implements Criteria {

	/**
	 * The column to apply the predicate to.
	 */
	private final Column column;

	/**
	 * The aggregate predicate to apply.
	 */
	private final Aggregate aggregate;

	/**
	 * The predicate operator.
	 */
	private final Operator operator;

	/**
	 * The predicate value.
	 */
	private final Value value;

	/**
	 * Constructor of {@link MatchCriteria}.
	 * 
	 * @param aggregate
	 *            the {@link Aggregate}
	 * @param operator
	 *            the {@link Operator}
	 * @param value
	 *            the string value
	 */
	public MatchCriteria(Aggregate aggregate, Operator operator, String value) {
		this(aggregate, null, operator, new Value(value));
	}

	/**
	 * Constructor of {@link MatchCriteria}.
	 * 
	 * @param aggregate
	 *            the {@link Aggregate}
	 * @param operator
	 *            the {@link Operator}
	 * @param value
	 *            the numeric value
	 */
	public MatchCriteria(Aggregate aggregate, Operator operator, Number value) {
		this(aggregate, null, operator, new Value(value));
	}

	/**
	 * Constructor of {@link MatchCriteria}.
	 * 
	 * @param aggregate
	 *            the {@link Aggregate}
	 * @param operator
	 *            the {@link Operator}
	 * @param value
	 *            the boolean value
	 */
	public MatchCriteria(Aggregate aggregate, Operator operator, Boolean value) {
		this(aggregate, null, operator, new Value(value));
	}

	/**
	 * Constructor of {@link MatchCriteria}.
	 * 
	 * @param aggregate
	 *            the {@link Aggregate}
	 * @param operator
	 *            the {@link Operator}
	 * @param value
	 *            the object value
	 */
	public MatchCriteria(Aggregate aggregate, Operator operator, Value value) {
		this(aggregate, null, operator, value);
	}

	/**
	 * Constructor of {@link MatchCriteria}.
	 * 
	 * @param table
	 *            the {@link Table}
	 * @param columnName
	 *            the column name
	 * @param operator
	 *            the {@link Operator}
	 * @param value
	 *            the string value
	 */
	public MatchCriteria(Table table, String columnName, Operator operator,
			String value) {
		this(null, table.getColumn(columnName), operator, new Value(value));
	}

	/**
	 * Constructor of {@link MatchCriteria}.
	 * 
	 * @param table
	 *            the {@link Table}
	 * @param columnName
	 *            the column name
	 * @param operator
	 *            the {@link Operator}
	 * @param value
	 *            the numeric value
	 */
	public MatchCriteria(Table table, String columnName, Operator operator,
			Number value) {
		this(null, table.getColumn(columnName), operator, new Value(value));
	}

	/**
	 * Constructor of {@link MatchCriteria}.
	 * 
	 * @param table
	 *            the {@link Table}
	 * @param columnName
	 *            the column name
	 * @param operator
	 *            the {@link Operator}
	 * @param value
	 *            the boolean value
	 */
	public MatchCriteria(Table table, String columnName, Operator operator,
			Boolean value) {
		this(null, table.getColumn(columnName), operator, new Value(value));
	}

	/**
	 * Constructor of {@link MatchCriteria}.
	 * 
	 * @param table
	 *            the {@link Table}
	 * @param columnName
	 *            the column name
	 * @param operator
	 *            the {@link Operator}
	 * @param value
	 *            the object value
	 */
	public MatchCriteria(Table table, String columnName, Operator operator,
			Value value) {
		this(null, table.getColumn(columnName), operator, value);
	}

	/**
	 * Constructor of {@link MatchCriteria}.
	 * 
	 * @param table
	 *            the {@link Table}
	 * @param columnName
	 *            the column name
	 * @param value
	 *            the string value
	 */
	public MatchCriteria(Table table, String columnName, String value) {
		this(table.getColumn(columnName), new Value(value));
	}

	/**
	 * Constructor of {@link MatchCriteria}.
	 * 
	 * @param table
	 *            the {@link Table}
	 * @param columnName
	 *            the column name
	 * @param value
	 *            the numeric value
	 */
	public MatchCriteria(Table table, String columnName, Number value) {
		this(table.getColumn(columnName), new Value(value));
	}

	/**
	 * Constructor of {@link MatchCriteria}.
	 * 
	 * @param table
	 *            the {@link Table}
	 * @param columnName
	 *            the column name
	 * @param value
	 *            the boolean value
	 */
	public MatchCriteria(Table table, String columnName, Boolean value) {
		this(table.getColumn(columnName), new Value(value));
	}

	/**
	 * Constructor of {@link MatchCriteria}.
	 * 
	 * @param table
	 *            the {@link Table}
	 * @param columnName
	 *            the column name
	 * @param value
	 *            the object value
	 */
	public MatchCriteria(Table table, String columnName, Value value) {
		this(table.getColumn(columnName), new Value(value));
	}

	/**
	 * Constructor of {@link MatchCriteria}.
	 * 
	 * @param column
	 *            the {@link Column}
	 * @param value
	 *            the string value
	 */
	public MatchCriteria(Column column, String value) {
		this(null, column, Operator.EQUALS, new Value(value));
	}

	/**
	 * Constructor of {@link MatchCriteria}.
	 * 
	 * @param column
	 *            the {@link Column}
	 * @param value
	 *            the numeric value
	 */
	public MatchCriteria(Column column, Number value) {
		this(null, column, Operator.EQUALS, new Value(value));
	}

	/**
	 * Constructor of {@link MatchCriteria}.
	 * 
	 * @param column
	 *            the {@link Column}
	 * @param value
	 *            the boolean value
	 */
	public MatchCriteria(Column column, Boolean value) {
		this(null, column, Operator.EQUALS, new Value(value));
	}

	/**
	 * Constructor of {@link MatchCriteria}.
	 * 
	 * @param column
	 *            the {@link Column}
	 * @param value
	 *            the object value
	 */
	public MatchCriteria(Column column, Value value) {
		this(null, column, Operator.EQUALS, value);
	}

	/**
	 * Constructor of {@link MatchCriteria}.
	 * 
	 * @param aggregate
	 *            the {@link Aggregate}
	 * @param column
	 *            the {@link Column}
	 * @param operator
	 *            the {@link Operator}
	 * @param value
	 *            the object value
	 */
	public MatchCriteria(Aggregate aggregate, Column column, Operator operator,
			Value value) {
		this.aggregate = aggregate;
		this.column = column;
		this.operator = operator;
		this.value = value;
	}

	@Override
	public void output(StringBuilder builder) {
		if (column != null) {
			column.output(builder);
		} else {
			aggregate.output(builder);
		}

		builder.append(" ").append(operator.getSymbol()).append(" ");
		value.output(builder);
	}

}
