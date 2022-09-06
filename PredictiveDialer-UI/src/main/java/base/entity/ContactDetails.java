package base.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
public class ContactDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer contactId;

	private Integer contactListId;

	@Column(name = "FNAME")
	private String firstName;
	@Column(name = "MNAME")
	private String middleName;
	@Column(name = "LNAME")
	private String lastName;

	private String phone1;
	private String phone2;
	private String landline;

	private String email1;
	private String email2;

	private String street;
	private String city;
	private String state;
	private String country;
	private String zip;

	private String matric1;
	private String matric2;
	private String matric3;
	private String matric4;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

}
