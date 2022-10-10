package base.entity.quiz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Test_Set")
public class TestSetEntity {
	@Id
	@GeneratedValue
	private Integer testSetId;
	
	private Integer assignmentId;

	@Column(nullable = false)
	private String testSetName;

//	@Column(nullable = false)
//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
////	@JoinTable(name = "Set_Question_Config", inverseJoinColumns = @JoinColumn(name = "testSetId"))
//	private List<QuestionEntity> questionsList;
}
