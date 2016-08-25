package com.github.sql.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.github.sql.builder.aggregate.Aggregate;
import com.github.sql.builder.aggregate.Count;
import com.github.sql.builder.constants.Operator;
import com.github.sql.builder.criteria.MatchCriteria;
import com.github.sql.builder.criteria.NotInCriteria;
import com.github.sql.builder.model.Column;
import com.github.sql.builder.model.Table;
import com.github.sql.builder.model.Value;
import com.github.sql.builder.parameter.NamedParameter;

public class SelectBuilderTest {

	@Test
	public void aggregateFunctionTest() {
		Table table = new Table("schema", "users_orders", "o");

		SelectBuilder selectBuilder = new SelectBuilder(table);

		Aggregate aggregate = new Count(table, "order_amount");

		// get users who ordered five times or mores
		selectBuilder
				.select("user_id")
				.select(aggregate)
				.groupBy("user_id")
				.having(new MatchCriteria(aggregate,
						Operator.GREATER_THAN_OR_EQUALS, 5));

		String query = selectBuilder.build();

		assertNotNull(query);
		assertEquals("select o.user_id, count(o.order_amount) "
				+ "from schema.users_orders o " + "group by o.user_id "
				+ "having(o.order_amount >= 5)", query);
	}

	@Test
	public void joinSelectTest() {
		Table table = new Table("schema", "users", "u");
		Table joinedTable = new Table("schema", "users_orders", "o");

		SelectBuilder selectBuilder = new SelectBuilder(table);

		selectBuilder
				.select("id_user")
				.select("user_name")
				.select("user_email")
				.select("user_password")
				.select(joinedTable, "order_amount")
				.join("id_user", joinedTable, "user_id")
				.where(new NamedParameter(new Column(table, "user_name"),
						"username")).order("user_name").nullsLast();

		String query = selectBuilder.build();

		assertNotNull(query);
		assertEquals(
				"select u.id_user, u.user_name, u.user_email, u.user_password, o.order_amount "
						+ "from schema.users u "
						+ "inner join schema.users_orders o on o.user_id = u.id_user "
						+ "where u.user_name = :username "
						+ "order by u.user_name asc " + "nulls last", query);
	}

	@Test
	public void inCriteriaTest() {
		Table table = new Table("schema", "users", "u");

		SelectBuilder selectBuilder = new SelectBuilder(table);

		selectBuilder
				.select("id_user")
				.select("user_name")
				.select("user_email")
				.select("user_password")
				.where(new NotInCriteria(table, "user_name", new Value(
						"john.doe@github.com"),
						new Value("jane.doe@github.com")));

		String query = selectBuilder.build();

		assertNotNull(query);
		assertEquals(
				"select u.id_user, u.user_name, u.user_email, u.user_password "
						+ "from schema.users u "
						+ "where u.user_name not in ('john.doe@github.com', 'jane.doe@github.com')",
				query);
	}

}
