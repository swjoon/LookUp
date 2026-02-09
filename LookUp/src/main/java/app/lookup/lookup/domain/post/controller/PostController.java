package app.lookup.lookup.domain.post.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.lookup.lookup.domain.post.dto.req.CreatePostDto;
import app.lookup.lookup.domain.post.dto.res.GetPostDto;
import app.lookup.lookup.domain.post.service.PostService;
import app.lookup.lookup.global.dto.request.PageRequest;
import app.lookup.lookup.global.dto.request.ScrollRequest;
import app.lookup.lookup.global.dto.response.ApiResponse;
import app.lookup.lookup.global.dto.response.PageResponse;
import app.lookup.lookup.global.dto.response.ScrollResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;

	@PostMapping
	public ApiResponse<Long> createPost(@RequestBody final CreatePostDto dto) {

		Long res = postService.savePost(dto);

		return ApiResponse.of(true, HttpStatus.CREATED, "게시글 생성", res);
	}

	@GetMapping("/page")
	public ApiResponse<PageResponse<GetPostDto>> getPostPage(
		final PageRequest pageRequest
	) {

		PageResponse<GetPostDto> res = postService.getPostPage(pageRequest);

		return ApiResponse.of(true, HttpStatus.OK, "페이지 조회", res);
	}

	@GetMapping("/scroll")
	public ApiResponse<ScrollResponse<GetPostDto>> getPostScroll(
		final ScrollRequest scrollRequest
	) {

		ScrollResponse<GetPostDto> res = postService.getPostScroll(scrollRequest);

		return ApiResponse.of(true, HttpStatus.OK, "스크롤 조회", res);
	}

}
