package base.model;

import java.util.List;

import lombok.Data;

@Data
public class TestSetModel {
	private String testSetId;
	private String testSetName;

	private List<QuestionModel> questionList;

}
