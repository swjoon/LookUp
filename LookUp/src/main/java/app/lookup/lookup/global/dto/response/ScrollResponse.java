package app.lookup.lookup.global.dto.response;

import java.util.List;

public record ScrollResponse<T>(
	List<T> data,
	int pageSize,
	int numberOfElements,
	boolean hasNext
) {

	public static <T> ScrollResponse<T> from(
		List<T> data,
		int pageSize,
		int numberOfElements,
		boolean hasNext
	) {
		return new ScrollResponse<>(
			data,
			pageSize,
			numberOfElements,
			hasNext
		);
	}
}
