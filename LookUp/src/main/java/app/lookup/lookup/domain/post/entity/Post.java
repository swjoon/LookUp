package app.lookup.lookup.domain.post.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "tbl_post")
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postId;

	private String title;

	private String content;

	private Long dummyId1;

	private Long dummyId2;

	private Long dummyId3;

	public static Post create(String title, String content, Long dummyId1, Long dummyId2, Long dummyId3) {
		return Post.builder()
			.title(title)
			.content(content)
			.dummyId1(dummyId1)
			.dummyId2(dummyId2)
			.dummyId3(dummyId3)
			.build();
	}
}
