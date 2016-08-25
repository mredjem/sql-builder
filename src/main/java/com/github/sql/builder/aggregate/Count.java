package com.github.sql.builder.aggregate;

import com.github.sql.builder.model.Column;
import com.github.sql.builder.model.Table;

public class Count extends AbstractAggregate {

	public Count(Table table, String columnName) {
		super(table, columnName);
	}

	public Count(Column column) {
		super(column);
	}

	@Override
	public String getFunction() {
		return "count";
	}

}
