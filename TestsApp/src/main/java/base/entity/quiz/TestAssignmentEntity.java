package base.entity.quiz;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "Test_Assignment")
public class TestAssignmentEntity {
	@Id
	@GeneratedValue
	private Integer assignmentId;
	
	private String candidateName;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String secretCode;

	private Double duration;

//	@Column(nullable = false)
//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
////	@JoinTable(name = "Assignment_Set_config", inverseJoinColumns = @JoinColumn(name = "testAssignmentId"))
//	private List<TestSetEntity> testSet;

	@Column(nullable = false)
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Column(nullable = false)
	@CreationTimestamp
	@Temporal(TemporalType.TIME)
	private Date startTime;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;
}
