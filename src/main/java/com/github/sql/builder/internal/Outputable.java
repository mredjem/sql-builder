package com.github.sql.builder.internal;

/**
 * Outputable SQL query subpart.
 * 
 * @author Medhi
 *
 */
public interface Outputable {

	/**
	 * Output to a {@link StringBuilder}.
	 * 
	 * @param builder
	 *            the {@link StringBuilder}
	 */
	void output(StringBuilder builder);

}
