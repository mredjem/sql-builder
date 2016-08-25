package com.github.sql.builder.aggregate;

import com.github.sql.builder.model.Column;
import com.github.sql.builder.model.Table;

public class Sum extends AbstractAggregate {

	public Sum(Table table, String columnName) {
		super(table, columnName);
	}

	public Sum(Column column) {
		super(column);
	}

	@Override
	public String getFunction() {
		return "sum";
	}

}
