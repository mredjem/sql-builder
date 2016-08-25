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

		insertBuilder.setValue("user_id", 1L)
				.setValue("user_first_name", "John")
				.setValue("user_last_name", "DOE")
				.setValue("user_email", "john.doe@github.com")
				.setValue("user_password", "*****");

		String query = insertBuilder.build();

		assertNotNull(query);
		assertEquals(
				"insert into schema.users(user_id, user_first_name, user_last_name, user_email, user_password) "
						+ "values (1, 'John', 'DOE', 'john.doe@github.com', '*****')",
				query);
	}

}
