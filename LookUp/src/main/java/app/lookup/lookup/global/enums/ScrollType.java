package app.lookup.lookup.global.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ScrollType {
	PREV("prev"), NEXT("next");

	private final String value;

	ScrollType(String value) {
		this.value = value;
	}

	@JsonCreator
	public static ScrollType from(String value) {
		if (value == null)
			return NEXT;

		return value.equalsIgnoreCase(PREV.value) ? PREV : NEXT;
	}
}
