package app.lookup.lookup.domain.post.dto.req;

public record CreatePostDto(
	String title,
	String content,
	Long dummyId1,
	Long dummyId2,
	Long dummyId3
) {
}
