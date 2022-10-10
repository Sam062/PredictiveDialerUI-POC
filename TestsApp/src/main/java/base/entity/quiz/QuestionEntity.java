package base.entity.quiz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Question_Data")
public class QuestionEntity {
	@Id
	@GeneratedValue
	private Integer qid;

	private Integer testSetId;

	@Column(nullable = false)
	private String questionStatement;

	@Column(nullable = false)
	private Integer marks;

	@Column(nullable = false)
	private String questionType;

	@Column(nullable = false)
	private String correctAnswer;

	@Column(nullable = false)
	private String questionCategory; // Java/Python/DB...

//	@Column(nullable = false)
//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
////	@JoinTable(name = "Set_Question_Config", inverseJoinColumns = @JoinColumn(name = "qid"))
//	private List<QuestionOptions> options;
}
