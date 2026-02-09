package app.lookup.lookup.domain.dummy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "tbl_dummy_one")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DummyOne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dummyOneId;

	private String dummyOneName;

	private String dummyOneContent;
}
