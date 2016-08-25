package com.github.sql.builder.model;

import com.github.sql.builder.internal.Outputable;

/**
 * Represent a SQL table column.
 * 
 * @author Medhi
 *
 */
public class Column implements Outputable {

	/**
	 * The column table.
	 */
	private final Table table;

	/**
	 * The column name.
	 */
	private final String name;

	/**
	 * Constructor of {@link Column}.
	 * 
	 * @param table
	 *            the {@link Table}
	 * @param name
	 *            the name
	 */
	public Column(Table table, String name) {
		this.table = table;
		this.name = name;
	}

	/**
	 * Returns this column {@link Table}.
	 * 
	 * @return a {@link Table}
	 */
	public Table getTable() {
		return table;
	}

	/**
	 * Returns this column name.
	 * 
	 * @return a String
	 */
	public String getName() {
		return name;
	}

	@Override
	public void output(StringBuilder builder) {
		if (table.hasAlias()) {
			builder.append(table.getAlias()).append(".");
		}
		builder.append(name);
	}

}
