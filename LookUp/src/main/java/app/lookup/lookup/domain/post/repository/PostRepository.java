package app.lookup.lookup.domain.post.repository;

import app.lookup.lookup.domain.post.dto.res.GetPostDto;
import app.lookup.lookup.domain.post.entity.Post;
import app.lookup.lookup.global.dto.request.PageRequest;
import app.lookup.lookup.global.dto.request.ScrollRequest;
import app.lookup.lookup.global.dto.response.PageResponse;
import app.lookup.lookup.global.dto.response.ScrollResponse;

public interface PostRepository {

	Long save(final Post post);

	PageResponse<GetPostDto> getPostPage(final PageRequest pageRequest);

	ScrollResponse<GetPostDto> getPostScroll(final ScrollRequest scrollRequest);

}
