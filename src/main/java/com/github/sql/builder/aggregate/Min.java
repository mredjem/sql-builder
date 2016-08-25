package com.github.sql.builder.aggregate;

import com.github.sql.builder.model.Column;
import com.github.sql.builder.model.Table;

public class Min extends AbstractAggregate {

	public Min(Table table, String columnName) {
		super(table, columnName);
	}

	public Min(Column column) {
		super(column);
	}

	@Override
	public String getFunction() {
		return "min";
	}

}
