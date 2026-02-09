package app.lookup.lookup.global.dto.request;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import app.lookup.lookup.global.enums.Order;
import jakarta.validation.constraints.Min;

/**
 * page 목록 요청
 *
 * @param page  페이지 번호
 * @param size  페이지 사이즈
 * @param sort  정렬 필드
 * @param order 정렬 기준
 */
public record PageRequest(
	@Min(0)
	Integer page,

	@Min(1)
	Integer size,

	String sort,

	Order order
) {
	public PageRequest {
		page = page == null ? 0 : page;
		size = size == null ? 10 : size;
	}

	public Pageable toPageable() {
		String sortBy = (sort == null || sort.isBlank()) ? "createdAt" : sort;

		Sort.Direction direction = order == Order.ASC ? Sort.Direction.ASC : Sort.Direction.DESC;

		return org.springframework.data.domain.PageRequest.of(page, size, Sort.by(direction, sortBy));
	}
}
