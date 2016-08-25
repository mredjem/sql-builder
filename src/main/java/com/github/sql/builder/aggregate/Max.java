package com.github.sql.builder.aggregate;

import com.github.sql.builder.model.Column;
import com.github.sql.builder.model.Table;

public class Max extends AbstractAggregate {

	public Max(Table table, String columnName) {
		super(table, columnName);
	}

	public Max(Column column) {
		super(column);
	}

	@Override
	public String getFunction() {
		return "max";
	}

}
