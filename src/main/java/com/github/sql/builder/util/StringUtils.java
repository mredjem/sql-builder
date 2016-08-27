package com.github.sql.builder.util;

/**
 * Functions helper to manipulate strings.
 * 
 * @author Medhi
 *
 */
public final class StringUtils {

	private StringUtils() {
	}

	/**
	 * Escape the string value to be safe for SQL queries.
	 * 
	 * @param value
	 *            the string value
	 * @return a string
	 */
	public static String escapeSql(String value) {
		if (value == null) {
			return "";
		}

		StringBuilder builder = new StringBuilder();
		// escape simple quotes
		builder.append('\'').append(value.replace("'", "''")).append('\'');

		return builder.toString();
	}

}
