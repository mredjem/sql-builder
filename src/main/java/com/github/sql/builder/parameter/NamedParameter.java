package com.github.sql.builder.parameter;

import com.github.sql.builder.model.Column;

public class NamedParameter implements Parameter {

	private final Column column;

	private final String name;

	public NamedParameter(Column column, String name) {
		this.column = column;
		this.name = name;
	}

	@Override
	public void output(StringBuilder builder) {
		column.output(builder);
		builder.append(" = :").append(name);
	}

}
