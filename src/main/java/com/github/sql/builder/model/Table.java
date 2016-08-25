package com.github.sql.builder.model;

import com.github.sql.builder.internal.Outputable;

/**
 * Represent a SQL table.
 * 
 * @author Medhi
 *
 */
public class Table implements Outputable {

	/**
	 * Table schema.
	 */
	private final String schema;

	/**
	 * Table name.
	 */
	private final String table;

	/**
	 * Table alias.
	 */
	private final String alias;

	/**
	 * Constructor of {@link Table}.
	 * 
	 * @param schema
	 *            the schema
	 * @param table
	 *            the name
	 * @param alias
	 *            the alias
	 */
	public Table(String schema, String table, String alias) {
		this.schema = schema;
		this.table = table;
		this.alias = alias;
	}

	/**
	 * Constructor of {@link Table}.
	 * 
	 * @param table
	 *            the name
	 * @param alias
	 *            the alias
	 */
	public Table(String table, String alias) {
		this(null, table, alias);
	}

	/**
	 * Constructor of {@link Table}.
	 * 
	 * @param table
	 *            the name
	 */
	public Table(String table) {
		this(null, table, null);
	}

	public Column getColumn(String name) {
		return new Column(this, name);
	}

	public String getSchema() {
		return schema;
	}

	public boolean hasSchema() {
		return schema != null;
	}

	public String getTable() {
		return table;
	}

	public String getAlias() {
		return alias;
	}

	public boolean hasAlias() {
		return alias != null;
	}

	@Override
	public void output(StringBuilder builder) {
		if (hasSchema()) {
			builder.append(schema).append(".");
		}

		builder.append(table);

		if (hasAlias()) {
			builder.append(" ").append(alias);
		}
	}

}
