package com.github.sql.builder;

import java.util.ArrayList;
import java.util.List;

import com.github.sql.builder.criteria.Criteria;
import com.github.sql.builder.model.Column;
import com.github.sql.builder.model.ColumnValue;
import com.github.sql.builder.model.Table;
import com.github.sql.builder.model.Value;
import com.github.sql.builder.parameter.Parameter;

/**
 * Builder to construct complex SQL update queries.
 * 
 * @author Medhi
 *
 */
public class UpdateBuilder extends AbstractBuilder {

	/**
	 * Query set of columns to update and their new values.
	 */
	private final List<ColumnValue> values = new ArrayList<ColumnValue>();

	/**
	 * Query criterias.
	 */
	private final List<Criteria> criterias = new ArrayList<Criteria>();

	/**
	 * Query parameters.
	 */
	private final List<Parameter> parameters = new ArrayList<Parameter>();

	/**
	 * Query table to update.
	 */
	private final Table table;

	/**
	 * Constructor of {@link UpdateBuilder}.
	 * 
	 * @param table
	 *            the main {@link Table}
	 */
	public UpdateBuilder(Table table) {
		this.table = table;
	}

	/**
	 * Add a value to update for the specified column name.
	 * 
	 * @param columnName
	 *            the colunm which value will be updated
	 * @param value
	 *            the new value
	 * @return this {@link UpdateBuilder}
	 */
	public UpdateBuilder set(String columnName, Object value) {
		Column column = table.getColumn(columnName);
		values.add(new ColumnValue(column, new Value(value)));
		return this;
	}

	/**
	 * Add a {@link Criteria} to the update query.
	 * 
	 * @param criteria
	 *            the {@link Criteria}
	 * @return this {@link UpdateBuilder}
	 */
	public UpdateBuilder where(Criteria criteria) {
		criterias.add(criteria);
		return this;
	}

	/**
	 * Add a {@link Parameter} to the update query.
	 * 
	 * @param parameter
	 *            the {@link Parameter}
	 * @return this {@link UpdateBuilder}
	 */
	public UpdateBuilder where(Parameter parameter) {
		parameters.add(parameter);
		return this;
	}

	@Override
	public String build() {
		StringBuilder builder = new StringBuilder();

		table.output(builder.append("update "));

		builder.append(" set ");

		print(builder, values, ", ");

		if (!criterias.isEmpty() || !parameters.isEmpty()) {
			builder.append(" where ");
		}

		if (!criterias.isEmpty()) {
			print(builder, criterias, " and ");
		}

		if (!parameters.isEmpty()) {
			print(builder, parameters, " and ");
		}

		return builder.toString();
	}

}
