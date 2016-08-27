# sql-builder

A lightweight Java librairy for creating simple or complex SQL queries in an easy way.

[![Build Status](https://travis-ci.org/mredjem/sql-builder.svg?branch=master)](https://travis-ci.org/mredjem/sql-builder)

## Why ?

Sometimes, when working on a web application or a REST api, you need to generate SQL queries based on dynamic criterias.

Thoses queries should be easy to read and easy to write. That is what this project aims for.


## How to install ?

This project is not available on Maven repository yet.


## What it does ?

sql-builder allows you to construct SQL queries easily by using the Builder pattern. 

The current supported features are :

 * select, insert, delete and update builders,
 * basic aggregate functions,
 * query predicates,
 * anonymous and named parameters for prepared statements,
 * inner join, order by, group by and having clauses

## How to use ?

**select query**

This example shows the creation of a select query from a table _customers_ located under the schema _myschema_ and referenced by the alias _c_ :

````java
Table customersTable = new Table("myschema", "customers", "c");

SelectBuilder selectBuilder = new SelectBuilder(customersTable);

selectBuilder.
  select("customer_id").
  select("customer_first_name").
  select("customer_last_name").
  select("customer_email").
  where(new MatchCriteria(customersTable, "customer_first_name", Operator.EQUALS, "John")).
  order("customer_email", true).
  nullsLast();
  
String query = selectBuilder.build();

// select c.user_id, c.user_first_name, c.user_last_name, c.user_email
// from myschema.customers c
// where c.user_first_name = 'John'
// order by c.user_email desc
// nulls last
````

**update query**

Depending on the use case, update queries can be built by using complex predicates too :

````java
Table menuTable = new Table("menus", "m");

UpdateBuilder updateBuilder = new UpdateBuilder(menuTable);

updateBuilder.
  set("menu_label", "A delicious meal").
  set("menu_price", 8).
  where(new NamedParameter(new Column(menuTable, "menu_id"), "menuId");
  
String query = updateBuilder.build();

// update menus m set m.menu_label = 'A delicious meal', m.menu_price = 8
// where m.menu_id = :menuId
````

**insert query**

Insert queries are slightly simpler :

````java
Table ordersTable = new Table("orders");

InsertBuilder insertBuilder = new InsertBuilder(ordersTable);

insertBuilder.
  add("order_id", 5L).
  add("user_id", 2L).
  add("order_amount", 10).
  add("order_label", "kid's menu");
  
String query = insertBuilder.build();

// insert into orders (order_id, user_id, order_amount, order_label)
// values(5, 2, 100, 'kid''s menu')
````

**delete query**

Delete queries support predicates too :

````java
Table badPayersTable = new Table("badPayers");

DeleteBuilder deleteBuilder = new DeleteBuilder(badPayersTable);

deleteBuilder.
  where(new MatchCriteria(table, "bad_payer_first_name", "John")).
  where(new MatchCriteria(table, "bad_payer_last_name", Operator.LIKE, "Do?"));
  
String query = deleteBuilder.build();

// delete from badPayers
// where bad_payer_first_name = 'John' and bad_payer_last_name like 'Do?'
````
