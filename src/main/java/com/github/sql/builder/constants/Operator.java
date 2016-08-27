package com.github.sql.builder.constants;

/**
 * SQL operators symbols.
 * 
 * @author Medhi
 *
 */
public enum Operator {
	
	EQUALS("="),
	NOT_EQUALS("<>"),
	LIKE("like"),
	GREATER_THAN(">"),
	GREATER_THAN_OR_EQUALS(">="),
	LOWER_THAN("<"),
	LOWER_THAN_OR_EQUALS("<=");
	
	private final String symbol;
	
	Operator(String symbol) {
		this.symbol = symbol;
	}
	
	public String getSymbol() {
		return symbol;
	}

}
