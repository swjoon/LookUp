package app.lookup.lookup.domain.post.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.lookup.lookup.domain.post.dto.req.CreatePostDto;
import app.lookup.lookup.domain.post.dto.res.GetPostDto;
import app.lookup.lookup.domain.post.entity.Post;
import app.lookup.lookup.domain.post.repository.PostRepository;
import app.lookup.lookup.global.dto.request.PageRequest;
import app.lookup.lookup.global.dto.request.ScrollRequest;
import app.lookup.lookup.global.dto.response.PageResponse;
import app.lookup.lookup.global.dto.response.ScrollResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

	private final PostRepository postRepository;

	@Transactional
	public Long savePost(final CreatePostDto dto) {

		return postRepository.save(
			Post.create(dto.title(), dto.content(), dto.dummyId1(), dto.dummyId2(), dto.dummyId3()));
	}

	@Override
	@Transactional(readOnly = true)
	public PageResponse<GetPostDto> getPostPage(final PageRequest pageRequest) {

		return postRepository.getPostPage(pageRequest);
	}

	@Override
	@Transactional(readOnly = true)
	public ScrollResponse<GetPostDto> getPostScroll(final ScrollRequest scrollRequest) {

		return postRepository.getPostScroll(scrollRequest);
	}

}
