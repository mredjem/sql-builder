package com.github.sql.builder.aggregate;

import com.github.sql.builder.model.Column;
import com.github.sql.builder.model.Table;

public class Avg extends AbstractAggregate {

	public Avg(Table table, String columnName) {
		super(table, columnName);
	}

	public Avg(Column column) {
		super(column);
	}

	@Override
	public String getFunction() {
		return "avg";
	}

}
