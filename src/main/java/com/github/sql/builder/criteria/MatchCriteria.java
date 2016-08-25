package com.github.sql.builder.criteria;

import com.github.sql.builder.aggregate.Aggregate;
import com.github.sql.builder.constants.Operator;
import com.github.sql.builder.model.Column;
import com.github.sql.builder.model.Table;
import com.github.sql.builder.model.Value;

public class MatchCriteria implements Criteria {

	private final Column column;

	private final Aggregate aggregate;

	private final Operator operator;

	private final Value value;

	public MatchCriteria(Aggregate aggregate, Operator operator, String value) {
		this(aggregate, aggregate.getColumn(), operator, new Value(value));
	}

	public MatchCriteria(Aggregate aggregate, Operator operator, Number value) {
		this(aggregate, aggregate.getColumn(), operator, new Value(value));
	}

	public MatchCriteria(Aggregate aggregate, Operator operator, Boolean value) {
		this(aggregate, aggregate.getColumn(), operator, new Value(value));
	}

	public MatchCriteria(Aggregate aggregate, Operator operator, Value value) {
		this(aggregate, aggregate.getColumn(), operator, value);
	}

	public MatchCriteria(Table table, String columnName, Operator operator,
			String value) {
		this(null, table.getColumn(columnName), operator, new Value(value));
	}

	public MatchCriteria(Table table, String columnName, Operator operator,
			Number value) {
		this(null, table.getColumn(columnName), operator, new Value(value));
	}

	public MatchCriteria(Table table, String columnName, Operator operator,
			Boolean value) {
		this(null, table.getColumn(columnName), operator, new Value(value));
	}

	public MatchCriteria(Table table, String columnName, Operator operator,
			Value value) {
		this(null, table.getColumn(columnName), operator, value);
	}

	public MatchCriteria(Table table, String columnName, String value) {
		this(table.getColumn(columnName), new Value(value));
	}

	public MatchCriteria(Table table, String columnName, Number value) {
		this(table.getColumn(columnName), new Value(value));
	}

	public MatchCriteria(Table table, String columnName, Boolean value) {
		this(table.getColumn(columnName), new Value(value));
	}

	public MatchCriteria(Table table, String columnName, Value value) {
		this(table.getColumn(columnName), new Value(value));
	}

	public MatchCriteria(Column column, String value) {
		this(null, column, Operator.EQUALS, new Value(value));
	}

	public MatchCriteria(Column column, Number value) {
		this(null, column, Operator.EQUALS, new Value(value));
	}

	public MatchCriteria(Column column, Boolean value) {
		this(null, column, Operator.EQUALS, new Value(value));
	}

	public MatchCriteria(Column column, Value value) {
		this(null, column, Operator.EQUALS, value);
	}

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
