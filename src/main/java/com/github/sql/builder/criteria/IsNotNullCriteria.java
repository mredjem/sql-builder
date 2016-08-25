package com.github.sql.builder.criteria;

import com.github.sql.builder.model.Column;
import com.github.sql.builder.model.Table;

public class IsNotNullCriteria implements Criteria {
	
	private final Column column;
	
	public IsNotNullCriteria(Table table, String columnName) {
		this(table.getColumn(columnName));
	}
	
	public IsNotNullCriteria(Column column) {
		this.column = column;
	}

	@Override
	public void output(StringBuilder builder) {
		column.output(builder);
		builder.append(" is not null");
	}

}
