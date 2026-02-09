package app.lookup.lookup.domain.post.repository;

import static app.lookup.lookup.domain.dummy.entity.QDummyOne.*;
import static app.lookup.lookup.domain.dummy.entity.QDummyThree.*;
import static app.lookup.lookup.domain.dummy.entity.QDummyTwo.*;
import static app.lookup.lookup.domain.post.entity.QPost.*;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import app.lookup.lookup.domain.post.dto.res.GetPostDto;
import app.lookup.lookup.global.dto.request.PageRequest;
import app.lookup.lookup.global.dto.request.ScrollRequest;
import app.lookup.lookup.global.dto.response.PageResponse;
import app.lookup.lookup.global.dto.response.ScrollResponse;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PostQueryRepository {

	private final JPAQueryFactory queryFactory;

	PageResponse<GetPostDto> getPostPageDto(final PageRequest pageRequest) {

		Pageable pageable = pageRequest.toPageable();

		List<GetPostDto> data = queryFactory.select(
				Projections.constructor(
					GetPostDto.class,
					post.postId,
					post.title,
					post.content,
					dummyOne.dummyOneName,
					dummyOne.dummyOneContent,
					dummyTwo.dummyTwoName,
					dummyTwo.dummyTwoContent,
					dummyThree.dummyThreeName,
					dummyThree.dummyThreeContent
				)
			)
			.from(post)
			.join(dummyOne).on(dummyOne.dummyOneId.eq(post.dummyId1))
			.join(dummyTwo).on(dummyTwo.dummyTwoId.eq(post.dummyId2))
			.join(dummyThree).on(dummyThree.dummyThreeId.eq(post.dummyId3))
			.orderBy(post.postId.desc())
			.offset(pageable.getOffset())
			.limit(pageable.getPageSize())
			.fetch();

		if (data.isEmpty()) {
			return PageResponse.from(Page.empty(pageable));
		}

		PageImpl<GetPostDto> page = new PageImpl<>(data, pageable, data.size());

		return PageResponse.from(page);
	}

	ScrollResponse<GetPostDto> getPostScrollDto(final ScrollRequest scrollRequest) {

		BooleanExpression orderCondition = orderCondition(scrollRequest);

		List<GetPostDto> data = queryFactory.select(
				Projections.constructor(
					GetPostDto.class,
					post.postId,
					post.title,
					post.content,
					dummyOne.dummyOneName,
					dummyOne.dummyOneContent,
					dummyTwo.dummyTwoName,
					dummyTwo.dummyTwoContent,
					dummyThree.dummyThreeName,
					dummyThree.dummyThreeContent
				)
			)
			.from(post)
			.join(dummyOne).on(dummyOne.dummyOneId.eq(post.dummyId1))
			.join(dummyTwo).on(dummyTwo.dummyTwoId.eq(post.dummyId2))
			.join(dummyThree).on(dummyThree.dummyThreeId.eq(post.dummyId3))
			.where(orderCondition)
			.orderBy(post.postId.desc())
			.limit(scrollRequest.size() + 1)
			.fetch();

		boolean hasNext = data.size() > scrollRequest.size();

		if (data.isEmpty()) {
			return ScrollResponse.from(null, scrollRequest.size(), 0, hasNext);
		}

		if (hasNext) {
			data.remove(data.size() - 1);
		}

		return ScrollResponse.from(data, scrollRequest.size(), data.size(), hasNext);
	}

	BooleanExpression orderCondition(final ScrollRequest scrollRequest) {
		if (scrollRequest.id() == null) {
			return null;
		}

		return post.postId.lt(scrollRequest.id());
	}

}
