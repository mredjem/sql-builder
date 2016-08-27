package com.github.sql.builder;

import java.util.ArrayList;
import java.util.List;

import com.github.sql.builder.model.Column;
import com.github.sql.builder.model.Table;
import com.github.sql.builder.model.Value;

/**
 * Builder to construct complex SQL insert queries.
 * 
 * @author Medhi
 *
 */
public class InsertBuilder extends AbstractBuilder {

	/**
	 * Columns which values will be inserted.
	 */
	private final List<Column> columns = new ArrayList<Column>();

	/**
	 * Columns insert values.
	 */
	private final List<Value> values = new ArrayList<Value>();

	/**
	 * Query table to insert into.
	 */
	private final Table table;

	/**
	 * Constructor of {@link InsertBuilder}.
	 * 
	 * @param table
	 *            the main {@link Table}
	 */
	public InsertBuilder(Table table) {
		this.table = table;
	}

	/**
	 * Add a value to insert for the specified column name.
	 * 
	 * @param columnName
	 *            the colunm which value will be inserted
	 * @param value
	 *            the value to insert
	 * @return this {@link InsertBuilder}
	 */
	public InsertBuilder add(String columnName, Object value) {
		Column column = table.getColumn(columnName);
		columns.add(column);
		values.add(new Value(value));
		return this;
	}

	@Override
	public String build() {
		StringBuilder builder = new StringBuilder();

		table.output(builder.append("insert into "));

		builder.append("(");
		print(builder, columns, ", ");
		builder.append(")");

		builder.append(" values (");
		print(builder, values, ", ");
		builder.append(")");

		return builder.toString();
	}

}
