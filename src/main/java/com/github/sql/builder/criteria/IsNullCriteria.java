package com.github.sql.builder.criteria;

import com.github.sql.builder.model.Column;

public class IsNullCriteria implements Criteria {

	private final Column column;
	
	public IsNullCriteria(Column column) {
		this.column = column;
	}

	@Override
	public void output(StringBuilder builder) {
		column.output(builder);
		builder.append(" is null");
	}

}
