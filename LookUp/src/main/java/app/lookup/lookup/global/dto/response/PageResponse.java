package app.lookup.lookup.global.dto.response;

import java.util.List;

import org.springframework.data.domain.Page;

public record PageResponse<T>(
	List<T> data,
	int pageNumber,
	int totalPages,
	int pageSize,
	long totalElements,
	boolean isFirst,
	boolean isLast
) {

	public static <T> PageResponse<T> from(Page<T> page) {
		return new PageResponse<>(
			page.getContent(),
			page.getNumber(),
			page.getTotalPages(),
			page.getSize(),
			page.getTotalElements(),
			page.isFirst(),
			page.isLast()
		);
	}
}
