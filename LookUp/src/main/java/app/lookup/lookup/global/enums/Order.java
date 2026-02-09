package app.lookup.lookup.global.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;

@Getter
public enum Order {
	ASC("asc"), DESC("desc");

	private final String value;

	Order(String value) {
		this.value = value;
	}

	@JsonCreator
	public static Order from(String value) {
		if (value == null)
			return DESC;

		return value.equalsIgnoreCase(ASC.value) ? ASC : DESC;
	}
}
