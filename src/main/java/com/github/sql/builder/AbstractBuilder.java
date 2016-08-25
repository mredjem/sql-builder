package com.github.sql.builder;

import java.util.Iterator;
import java.util.List;

import com.github.sql.builder.internal.Outputable;

/**
 * Abstract SQL query builder.
 * 
 * @author Medhi
 *
 */
public abstract class AbstractBuilder implements Builder {

	/**
	 * Append a {@link List} of {@link Outputable} delimited by a separator to a
	 * {@link StringBuilder}.
	 * 
	 * @param builder
	 *            the {@link StringBuilder}
	 * @param printables
	 *            the {@link List} of {@link Outputable}
	 * @param separator
	 *            the separator
	 */
	protected void print(StringBuilder builder,
			List<? extends Outputable> printables, String separator) {

		Iterator<? extends Outputable> it = printables.iterator();

		boolean hasNext = it.hasNext();

		while (hasNext) {
			Outputable printable = it.next();
			printable.output(builder);

			hasNext = it.hasNext();
			if (hasNext) {
				builder.append(separator);
			}
		}
	}

}
