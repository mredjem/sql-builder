package com.github.sql.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.github.sql.builder.model.Column;
import com.github.sql.builder.model.Table;
import com.github.sql.builder.parameter.NamedParameter;

public class UpdateBuilderTest {

	@Test
	public void updateTest() {
		Table table = new Table("schema", "users", null);

		UpdateBuilder updateBuilder = new UpdateBuilder(table);

		updateBuilder
				.set("user_first_name", "Jane")
				.set("user_last_name", "Doe")
				.set("user_email", "jane.doe@github.com")
				.where(new NamedParameter(new Column(table, "user_id"),
						"userid"));

		String query = updateBuilder.build();

		assertNotNull(query);
		assertEquals(
				"update schema.users "
						+ "set user_first_name = 'Jane', user_last_name = 'Doe', user_email = 'jane.doe@github.com'"
						+ " where user_id = :userid", query);
	}

}
