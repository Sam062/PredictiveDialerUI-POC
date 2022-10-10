package base.entity.quiz;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Question_OPTN")
public class QuestionOptions {
	@Id
	@GeneratedValue
	private Integer optionId;

	private Integer questionId;

	private String optionValue;

//	@ElementCollection
//	@CollectionTable(name="Options", joinColumns=@JoinColumn(name="QuestionDataId"))
//	@Column(name="Option")
//	private List<String> options;
}
