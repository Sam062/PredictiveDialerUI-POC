package base.model;

import lombok.Data;

@Data
public class QuestionModel {
	private String qid;
	
	private String questionStatement;
	private String correctAnswer;
	private String marks;
	private String questionCategory;
	private String questionType;

	private Options options;

}
