package com.github.sql.builder;

import java.util.ArrayList;
import java.util.List;

import com.github.sql.builder.criteria.Criteria;
import com.github.sql.builder.model.Table;
import com.github.sql.builder.parameter.Parameter;

/**
 * Builder to construct complex SQL delete queries.
 * 
 * @author Medhi
 *
 */
public class DeleteBuilder extends AbstractBuilder {

	/**
	 * Query criterias.
	 */
	private final List<Criteria> criterias = new ArrayList<Criteria>();

	/**
	 * Query parameters.
	 */
	private final List<Parameter> parameters = new ArrayList<Parameter>();

	/**
	 * Query table to delete from.
	 */
	private final Table table;

	/**
	 * Constructor of {@link DeleteBuilder}.
	 * 
	 * @param table
	 *            the main {@link Table}
	 */
	public DeleteBuilder(Table table) {
		this.table = table;
	}

	/**
	 * Add a {@link Criteria} to the delete query.
	 * 
	 * @param criteria
	 *            the {@link Criteria}
	 * @return this {@link DeleteBuilder}
	 */
	public DeleteBuilder where(Criteria criteria) {
		criterias.add(criteria);
		return this;
	}

	/**
	 * Add a {@link Parameter} to the delete query.
	 * 
	 * @param parameter
	 *            the {@link Parameter}
	 * @return this {@link DeleteBuilder}
	 */
	public DeleteBuilder where(Parameter parameter) {
		parameters.add(parameter);
		return this;
	}

	@Override
	public String build() {
		StringBuilder builder = new StringBuilder();

		table.output(builder.append("delete from "));

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
