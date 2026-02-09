package app.lookup.lookup.global.error;

import java.net.BindException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.server.MethodNotAllowedException;

import app.lookup.lookup.global.dto.response.ApiResponse;
import app.lookup.lookup.global.error.exception.DomainErrorCode;
import app.lookup.lookup.global.error.exception.DomainException;
import app.lookup.lookup.global.error.exception.GlobalErrorCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * 지원하지 않는 HTTP 메소드 호출
	 *
	 * @param ex
	 * @return ResponseEntity
	 */
	@ExceptionHandler(MethodNotAllowedException.class)
	public ResponseEntity<ApiResponse<Void>> handleMethodNotAllowedException(
		MethodNotAllowedException ex) {

		log.error("handleMethodNotAllowedException", ex);
		final DomainErrorCode errorCode = GlobalErrorCode.METHOD_NOT_ALLOWED;

		return ResponseEntity.status(errorCode.getStatus())
			.body(ApiResponse.of(false, errorCode.getCode(), errorCode.getMessage()));
	}

	/**
	 * 지원하지 않는 HTTP 메소드 호출
	 *
	 * @param ex
	 * @return ResponseEntity
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ApiResponse<Void>> handleHttpRequestMethodNotSupportedException(
		HttpRequestMethodNotSupportedException ex) {

		log.error("handleHttpRequestMethodNotSupportedException", ex);
		final DomainErrorCode errorCode = GlobalErrorCode.METHOD_NOT_ALLOWED;

		return ResponseEntity.status(errorCode.getStatus())
			.body(ApiResponse.of(false, errorCode.getCode(), errorCode.getMessage()));
	}

	/**
	 * HandlerMethodValidationException 발생 시(단일 값, @Valid 또는 @Validated 에서 바인딩 에러)
	 *
	 * @param ex
	 * @return ResponseEntity
	 */
	@ExceptionHandler(HandlerMethodValidationException.class)
	public ResponseEntity<ApiResponse<Void>> handleMethodValidationException(
		HandlerMethodValidationException ex
	) {

		log.error("handleMethodValidationException", ex);
		final DomainErrorCode errorCode = GlobalErrorCode.INVALID_INPUT_VALUE;

		return ResponseEntity.status(errorCode.getStatus())
			.body(ApiResponse.of(false, errorCode.getCode(), errorCode.getMessage()));
	}

	/**
	 * BindException 발생 시(객체, @Valid 또는 @Validated 에서 바인딩 에러)
	 *
	 * @param ex
	 * @return ResponseEntity
	 */
	@ExceptionHandler(BindException.class)
	public ResponseEntity<ApiResponse<Void>> handleBindException(BindException ex) {

		log.error("handleBindException", ex);
		final DomainErrorCode errorCode = GlobalErrorCode.INVALID_INPUT_VALUE;

		return ResponseEntity.status(errorCode.getStatus())
			.body(ApiResponse.of(false, errorCode.getCode(), errorCode.getMessage()));
	}

	/**
	 * 권한이 없는 요청 시
	 *
	 * @param ex
	 * @return ResponseEntity
	 */
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ApiResponse<Void>> handleAccessDeniedException(
		AccessDeniedException ex
	) {

		log.error("handleAccessDeniedException", ex);
		final DomainErrorCode errorCode = GlobalErrorCode.HANDLE_ACCESS_DENIED;

		return ResponseEntity.status(errorCode.getStatus())
			.body(ApiResponse.of(false, errorCode.getCode(), errorCode.getMessage()));
	}

	/**
	 * 중복된 데이터 저장
	 *
	 * @param ex
	 * @return ResponseEntity
	 */
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ApiResponse<Void>> handleDataIntegrityViolationException(
		DataIntegrityViolationException ex
	) {

		log.error("handleDataIntegrityViolationException", ex);
		final DomainErrorCode errorCode = GlobalErrorCode.DUPLICATE_DATA;

		return ResponseEntity.status(errorCode.getStatus())
			.body(ApiResponse.of(false, errorCode.getCode(), errorCode.getMessage()));
	}

	/**
	 * Domain 에러 발 시
	 *
	 * @param ex
	 * @return ResponseEntity
	 */
	@ExceptionHandler(DomainException.class)
	public ResponseEntity<ApiResponse<Void>> handleDomainException(DomainException ex) {

		log.error("handleDomainException", ex);

		return ResponseEntity.status(ex.getDomainErrorCode().getStatus())
			.body(ApiResponse.of(false, ex.getDomainErrorCode().getCode(), ex.getDomainErrorCode().getMessage()));
	}

	/**
	 * 처리되지 않은 모든 예외에 대한 글로벌 핸들링
	 *
	 * @param ex
	 * @return ResponseEntity
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<Void>> handleException(Exception ex) {

		log.error("handleException", ex);
		DomainErrorCode errorCode = GlobalErrorCode.INTERNAL_SERVER_ERROR;

		return ResponseEntity.status(errorCode.getStatus())
			.body(ApiResponse.of(false, errorCode.getCode(), errorCode.getMessage()));
	}
}
