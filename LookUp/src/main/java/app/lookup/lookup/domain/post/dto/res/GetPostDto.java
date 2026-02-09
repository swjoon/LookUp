package app.lookup.lookup.domain.post.dto.res;

public record GetPostDto(
	Long postId,
	String title,
	String content,
	String dummyTitle1,
	String dummyContent1,
	String dummyTitle2,
	String dummyContent2,
	String dummyTitle3,
	String dummyContent3
) {
}
