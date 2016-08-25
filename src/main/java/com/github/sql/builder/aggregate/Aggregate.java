package com.github.sql.builder.aggregate;

import com.github.sql.builder.internal.Outputable;
import com.github.sql.builder.model.Column;

/**
 * Represent an SQL aggregate function.
 * 
 * @author Medhi
 *
 */
public interface Aggregate extends Outputable {

	/**
	 * Returns the {@link Column} on which the aggregation is operated.
	 * 
	 * @return a {@link Column}
	 */
	Column getColumn();

	/**
	 * Returns the aggregate function name.
	 * 
	 * @return a string
	 */
	String getFunction();

}
