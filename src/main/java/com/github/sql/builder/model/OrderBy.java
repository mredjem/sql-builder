package com.github.sql.builder.model;

import com.github.sql.builder.internal.Outputable;

public class OrderBy implements Outputable {
	
	private final Column column;
	
	private final boolean descending;
	
	public OrderBy(Column column, boolean descending) {
		this.column = column;
		this.descending = descending;
	}

	public Column getColumn() {
		return column;
	}

	public boolean isDescending() {
		return descending;
	}

	@Override
	public void output(StringBuilder builder) {
		column.output(builder);
		
		builder.
			append(" ").
			append(descending ? "desc" : "asc");
	}

}
