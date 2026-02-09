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
@Table(name = "tbl_dummy_two")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DummyTwo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dummyTwoId;

	private String dummyTwoName;

	private String dummyTwoContent;
}
