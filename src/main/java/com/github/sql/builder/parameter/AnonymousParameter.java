package com.github.sql.builder.parameter;

import com.github.sql.builder.model.Column;

public class AnonymousParameter implements Parameter {

	private final Column column;

	public AnonymousParameter(Column column) {
		this.column = column;
	}

	@Override
	public void output(StringBuilder builder) {
		column.output(builder);
		builder.append(" = ?");
	}

}
