package app.lookup.lookup.domain.post.repository;

import org.springframework.stereotype.Repository;

import app.lookup.lookup.domain.post.dto.res.GetPostDto;
import app.lookup.lookup.domain.post.entity.Post;
import app.lookup.lookup.global.dto.request.PageRequest;
import app.lookup.lookup.global.dto.request.ScrollRequest;
import app.lookup.lookup.global.dto.response.PageResponse;
import app.lookup.lookup.global.dto.response.ScrollResponse;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

	private final PostJpaRepository jpaRepository;
	private final PostQueryRepository queryRepository;

	@Override
	public Long save(final Post post) {

		return jpaRepository.save(post).getPostId();
	}

	@Override
	public PageResponse<GetPostDto> getPostPage(final PageRequest pageRequest) {

		return queryRepository.getPostPageDto(pageRequest);
	}

	@Override
	public ScrollResponse<GetPostDto> getPostScroll(final ScrollRequest scrollRequest) {

		return queryRepository.getPostScrollDto(scrollRequest);
	}
}
