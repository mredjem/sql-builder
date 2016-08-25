package com.github.sql.builder.util;

public final class StringUtils {

	private StringUtils() {
	}

	public static String escapeSql(String value) {
		if (value == null) {
			return "";
		}

		StringBuilder builder = new StringBuilder();
		builder.append('\'').append(value.replace("'", "''")).append('\'');

		return builder.toString();
	}

}
