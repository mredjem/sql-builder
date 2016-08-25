package com.github.sql.builder.model;

import com.github.sql.builder.constants.Operator;
import com.github.sql.builder.internal.Outputable;

public class InnerJoin implements Outputable {
	
	private final Column srcColumn; 
	
	private final Column destColumn;
	
	private final Operator operator;
	
	public InnerJoin(Column srcColumn, Column destColumn, Operator operator) {
		this.srcColumn = srcColumn;
		this.destColumn = destColumn;
		this.operator = operator;
	}
	
	public InnerJoin(Column srcColumn, Column destColumn) {
		this(srcColumn, destColumn, Operator.EQUALS);
	}

	@Override
	public void output(StringBuilder builder) {
		destColumn.getTable().output(builder);
		
		builder.append(" on ");
		
		destColumn.output(builder);
		
		builder.
			append(" ").
			append(operator.getSymbol()).
			append(" ");
		
		srcColumn.output(builder);
	}

}
