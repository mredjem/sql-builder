package com.github.sql.builder.model;

import com.github.sql.builder.constants.Operator;
import com.github.sql.builder.internal.Outputable;

/**
 * Represents a strict join.
 * 
 * @author Medhi
 *
 */
public class InnerJoin implements Outputable {

	/**
	 * The join source column.
	 */
	private final Column srcColumn;

	/**
	 * The join destination column.
	 */
	private final Column destColumn;

	/**
	 * The join operation.
	 */
	private final Operator operator;

	/**
	 * Constructor of {@link InnerJoin}.
	 * 
	 * @param srcColumn
	 *            the source {@link Column}
	 * @param destColumn
	 *            the destination {@link Column}
	 * @param operator
	 *            the {@link Operator}
	 */
	public InnerJoin(Column srcColumn, Column destColumn, Operator operator) {
		this.srcColumn = srcColumn;
		this.destColumn = destColumn;
		this.operator = operator;
	}

	/**
	 * Constructor of {@link InnerJoin}.
	 * 
	 * @param srcColumn
	 *            the source {@link Column}
	 * @param destColumn
	 *            the destination {@link Column}
	 */
	public InnerJoin(Column srcColumn, Column destColumn) {
		this(srcColumn, destColumn, Operator.EQUALS);
	}

	@Override
	public void output(StringBuilder builder) {
		destColumn.getTable().output(builder);

		builder.append(" on ");

		destColumn.output(builder);

		builder.append(" ").append(operator.getSymbol()).append(" ");

		srcColumn.output(builder);
	}

}
