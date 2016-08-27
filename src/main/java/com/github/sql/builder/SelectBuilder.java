package com.github.sql.builder;

import java.util.ArrayList;
import java.util.List;

import com.github.sql.builder.aggregate.Aggregate;
import com.github.sql.builder.criteria.Criteria;
import com.github.sql.builder.model.Column;
import com.github.sql.builder.model.InnerJoin;
import com.github.sql.builder.model.OrderBy;
import com.github.sql.builder.model.Table;
import com.github.sql.builder.parameter.Parameter;

/**
 * Builder to construct complex SQL select queries.
 * 
 * @author Medhi
 *
 */
public class SelectBuilder extends AbstractBuilder {

	/**
	 * Columns to select.
	 */
	private final List<Column> columns = new ArrayList<Column>();

	/**
	 * Aggregate functions.
	 */
	private final List<Aggregate> aggregates = new ArrayList<Aggregate>();

	/**
	 * Joined tables.
	 */
	private final List<InnerJoin> joins = new ArrayList<InnerJoin>();

	/**
	 * Query criterias.
	 */
	private final List<Criteria> criterias = new ArrayList<Criteria>();

	/**
	 * Query parameters.
	 */
	private final List<Parameter> parameters = new ArrayList<Parameter>();

	/**
	 * Query group by expressions.
	 */
	private final List<Column> groups = new ArrayList<Column>();

	/**
	 * Query group by having expressions.
	 */
	private final List<Criteria> havings = new ArrayList<Criteria>();

	/**
	 * Query order by expressions.
	 */
	private final List<OrderBy> orders = new ArrayList<OrderBy>();

	/**
	 * Query main table to select from.
	 */
	private final Table table;

	/**
	 * Query distinct flag.
	 */
	private boolean distinct;

	/**
	 * Query nulls order by flag.
	 */
	private Boolean nullsFirst;

	/**
	 * Constructor of {@link SelectBuilder}.
	 * 
	 * @param table
	 *            the main {@link Table}
	 */
	public SelectBuilder(Table table) {
		this.table = table;
	}

	/**
	 * Perform a distinct query select.
	 * 
	 * @return this {@link SelectBuilder}
	 */
	public SelectBuilder distinct() {
		distinct = true;
		return this;
	}

	/**
	 * Add the column to the select query, the column is assumed to belong to
	 * the {@link SelectBuilder#table}.
	 * 
	 * @param columnName
	 *            the column name to select
	 * @return this {@link SelectBuilder}
	 */
	public SelectBuilder select(String columnName) {
		return select(table.getColumn(columnName));
	}

	/**
	 * Add the column to select query.
	 * 
	 * @param column
	 *            the {@link Column}
	 * @return this {@link SelectBuilder}
	 */
	public SelectBuilder select(Column column) {
		return select(column.getTable(), column.getName());
	}

	/**
	 * Add the column belonging to the given {@link Table} to the select query.
	 * 
	 * @param table
	 *            the {@link Table}
	 * @param columnName
	 *            the column name
	 * @return this {@link SelectBuilder}
	 */
	public SelectBuilder select(Table table, String columnName) {
		columns.add(table.getColumn(columnName));
		return this;
	}

	public SelectBuilder select(Aggregate aggregate) {
		aggregates.add(aggregate);
		return this;
	}

	/**
	 * Add an {@link InnerJoin} to the select query.
	 * 
	 * @param join
	 *            the {@link InnerJoin}
	 * @return this {@link SelectBuilder}
	 */
	public SelectBuilder join(InnerJoin join) {
		joins.add(join);
		return this;
	}

	/**
	 * Add an inner join between this {@link Table} column name and the
	 * specified destination column.
	 * 
	 * @param srcColumnName
	 *            this source column name
	 * @param destTable
	 *            the destination {@link Table}
	 * @param destColumnName
	 *            the destination column name
	 * @return this {@link SelectBuilder}
	 */
	public SelectBuilder join(String srcColumnName, Table destTable,
			String destColumnName) {
		return join(table.getColumn(srcColumnName),
				destTable.getColumn(destColumnName));
	}

	/**
	 * Add an inner join between the specified {@link Table}.
	 * 
	 * @param srcTable
	 *            the source {@link Table}
	 * @param srcColumnName
	 *            the source column name
	 * @param destTable
	 *            the destination {@link Table}
	 * @param destColumnName
	 *            the destination column name
	 * @return this {@link SelectBuilder}
	 */
	public SelectBuilder join(Table srcTable, String srcColumnName,
			Table destTable, String destColumnName) {
		return join(srcTable.getColumn(srcColumnName),
				destTable.getColumn(destColumnName));
	}

	/**
	 * Add an inner join between the specified {@link Column}.
	 * 
	 * @param srcColumn
	 *            the source {@link Column}
	 * @param destColumn
	 *            the destination {@link Column}
	 * @return this {@link SelectBuilder}
	 */
	public SelectBuilder join(Column srcColumn, Column destColumn) {
		return join(new InnerJoin(srcColumn, destColumn));
	}

	/**
	 * Add a {@link Criteria} to the select query.
	 * 
	 * @param criteria
	 *            the {@link Criteria}
	 * @return this {@link SelectBuilder}
	 */
	public SelectBuilder where(Criteria criteria) {
		criterias.add(criteria);
		return this;
	}

	/**
	 * Add a {@link Parameter} to the select query.
	 * 
	 * @param parameter
	 *            the {@link Parameter}
	 * @return this {@link SelectBuilder}
	 */
	public SelectBuilder where(Parameter parameter) {
		parameters.add(parameter);
		return this;
	}

	/**
	 * Add a group by expression on the specified column name.
	 * 
	 * @param columnName
	 *            the column name
	 * @return this {@link SelectBuilder}
	 */
	public SelectBuilder groupBy(String columnName) {
		groups.add(table.getColumn(columnName));
		return this;
	}

	/**
	 * Add a group by expression on the specified {@link Column}.
	 * 
	 * @param column
	 *            the {@link Column}
	 * @return this {@link SelectBuilder}
	 */
	public SelectBuilder groupBy(Column column) {
		groups.add(column);
		return this;
	}

	/**
	 * Add a group by expression on the specified column name belonging to the
	 * specified {@link Table}.
	 * 
	 * @param table
	 *            the {@link Table}
	 * @param columnName
	 *            the column name
	 * @return this {@link SelectBuilder}
	 */
	public SelectBuilder groupBy(Table table, String columnName) {
		groups.add(table.getColumn(columnName));
		return this;
	}

	/**
	 * Add an having expression with the specified {@link Criteria}.
	 * 
	 * @param criteria
	 *            the {@link Criteria}
	 * @return this {@link SelectBuilder}
	 */
	public SelectBuilder having(Criteria criteria) {
		havings.add(criteria);
		return this;
	}

	public SelectBuilder order(Column column, boolean desc) {
		orders.add(new OrderBy(column, desc));
		return this;
	}

	public SelectBuilder order(String columnName) {
		return order(table.getColumn(columnName), false);
	}

	public SelectBuilder order(String columnName, boolean desc) {
		return order(table.getColumn(columnName), desc);
	}

	public SelectBuilder order(Column column) {
		return order(column, false);
	}

	public SelectBuilder order(OrderBy order) {
		return order(order.getColumn(), order.isDescending());
	}

	public SelectBuilder order(Table table, String columnName, boolean desc) {
		return order(table.getColumn(columnName), desc);
	}

	public SelectBuilder order(Table table, String columnName) {
		return order(table.getColumn(columnName), false);
	}

	/**
	 * Add an nulls first order modifier to the select query.
	 * 
	 * @return this {@link SelectBuilder}
	 */
	public SelectBuilder nullsFirst() {
		if (nullsFirst == null) {
			nullsFirst = Boolean.TRUE;
		}
		return this;
	}

	/**
	 * Add an nulls last order modifier to the select query.
	 * 
	 * @return this {@link SelectBuilder}
	 */
	public SelectBuilder nullsLast() {
		if (nullsFirst == null) {
			nullsFirst = Boolean.FALSE;
		}
		return this;
	}

	/**
	 * Create a string representing this select query.
	 * 
	 * @return a {@link String}
	 */
	@Override
	public String build() {
		StringBuilder builder = new StringBuilder();

		builder.append("select ");

		if (distinct) {
			builder.append("distinct ");
		}

		if (columns.isEmpty() && aggregates.isEmpty()) {
			builder.append("*");
		} else {
			print(builder, columns, ", ");
		}

		if (!aggregates.isEmpty()) {
			print(builder.append(columns.isEmpty() ? "" : ","), aggregates,
					", ");
		}

		table.output(builder.append(" from "));

		if (!joins.isEmpty()) {
			print(builder.append(" inner join "), joins, " ");
		}

		if (!criterias.isEmpty() || !parameters.isEmpty()) {
			builder.append(" where ");
		}

		if (!criterias.isEmpty()) {
			print(builder, criterias, " and ");
		}

		if (!parameters.isEmpty()) {
			print(builder, parameters, " and ");
		}

		if (!groups.isEmpty()) {
			print(builder.append(" group by "), groups, ", ");
		}

		if (!havings.isEmpty()) {
			print(builder.append(" having("), havings, ", ");
			builder.append(" )");
		}

		if (!orders.isEmpty()) {
			print(builder.append(" order by "), orders, ", ");
		}

		if (nullsFirst != null) {
			builder.append(nullsFirst ? " nulls first" : " nulls last");
		}

		return builder.toString();
	}

}
