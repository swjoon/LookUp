package app.lookup.lookup.domain.post.service;

import app.lookup.lookup.domain.post.dto.req.CreatePostDto;
import app.lookup.lookup.domain.post.dto.res.GetPostDto;
import app.lookup.lookup.global.dto.request.PageRequest;
import app.lookup.lookup.global.dto.request.ScrollRequest;
import app.lookup.lookup.global.dto.response.PageResponse;
import app.lookup.lookup.global.dto.response.ScrollResponse;

public interface PostService {

	Long savePost(final CreatePostDto dto);

	PageResponse<GetPostDto> getPostPage(final PageRequest pageRequest);

	ScrollResponse<GetPostDto> getPostScroll(final ScrollRequest scrollRequest);

}
