package com.github.sql.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.github.sql.builder.constants.Operator;
import com.github.sql.builder.criteria.MatchCriteria;
import com.github.sql.builder.model.Table;

public class DeleteBuilderTest {

	@Test
	public void deleteTest() {
		Table table = new Table("schema", "users", "u");

		DeleteBuilder deleteBuilder = new DeleteBuilder(table);

		deleteBuilder
				.where(new MatchCriteria(table, "user_first_name", "John"))
				.where(new MatchCriteria(table, "user_last_name",
						Operator.LIKE, "Do?"));

		String query = deleteBuilder.build();

		assertNotNull(query);
		assertEquals(
				"delete from schema.users u where u.user_first_name = 'John' and u.user_last_name like 'Do?'",
				query);
	}

}
