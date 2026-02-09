package app.lookup.lookup.global.dto.request;

import app.lookup.lookup.global.enums.Order;
import app.lookup.lookup.global.enums.ScrollType;
import jakarta.validation.constraints.Min;

/**
 * scroll 목록 요청
 *
 * @param order      정렬 기준 (ASC, DESC)
 * @param sort       정렬 필드
 * @param type       이전인지 다음인지 (Next, Prev)
 * @param fieldValue 정렬 필드 Value
 * @param id         Id
 * @param size       페이지 사이즈
 */
public record ScrollRequest(
	Order order,
	String sort,
	ScrollType type,
	String fieldValue,
	Long id,
	@Min(1)
	Integer size
) {
	public ScrollRequest {
		size = size == null ? 10 : size;
	}
}
