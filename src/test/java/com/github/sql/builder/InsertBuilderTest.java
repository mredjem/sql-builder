package com.github.sql.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.github.sql.builder.model.Table;

public class InsertBuilderTest {

	@Test
	public void insertTest() {
		Table table = new Table("schema", "users", null);

		InsertBuilder insertBuilder = new InsertBuilder(table);

		insertBuilder.add("user_id", 1L)
				.add("user_first_name", "John")
				.add("user_last_name", "DOE")
				.add("user_email", "john.doe@github.com")
				.add("user_password", "*****");

		String query = insertBuilder.build();

		assertNotNull(query);
		assertEquals(
				"insert into schema.users(user_id, user_first_name, user_last_name, user_email, user_password) "
						+ "values (1, 'John', 'DOE', 'john.doe@github.com', '*****')",
				query);
	}

}
