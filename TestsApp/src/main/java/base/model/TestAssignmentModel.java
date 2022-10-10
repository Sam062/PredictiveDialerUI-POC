package base.model;

import java.util.List;

import lombok.Data;

@Data
public class TestAssignmentModel {
	private String assessmentId;
	private String email;
	private String code;
	private String candidateName;
	private String duration;
	private String startTime;

	private List<TestSetModel> testSet;

}
