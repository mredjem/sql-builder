package com.github.sql.builder.aggregate;

import com.github.sql.builder.model.Column;
import com.github.sql.builder.model.Table;

public abstract class AbstractAggregate implements Aggregate {

	protected final Column column;

	public AbstractAggregate(Table table, String columnName) {
		this(table.getColumn(columnName));
	}

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
