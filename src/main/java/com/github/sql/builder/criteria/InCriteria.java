package com.github.sql.builder.criteria;

import com.github.sql.builder.model.Column;
import com.github.sql.builder.model.Table;
import com.github.sql.builder.model.Value;

public class InCriteria implements Criteria {

	private final Column column;

	private Value[] values;

	public InCriteria(Table table, String columnName, Value... values) {
		this(table.getColumn(columnName));
		this.values = values;
	}

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
