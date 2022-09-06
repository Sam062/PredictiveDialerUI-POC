package base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DLR_DATA")
public class DialerDataEntity {

	@Id
	@GeneratedValue
	@Column(name = "DLR_ID")
	private Integer dialerId;

	private String name;

	private String email;

	@Column(name = "CNTRY_CD")
	private String countryCode;

	@Column(name = "MBLE_1")
	private String mobile1;

	@Column(name = "MBLE_2")
	private String mobile2;

	private String zip;

	private Integer priority;

	private String status;

	private Integer contactListId;

	public DialerDataEntity() {
		super();
	}

	public DialerDataEntity(Integer dialerId, String name, String email, String countryCode, String mobile1,
			String mobile2, String zip, Integer priority, String status, Integer contactListId) {
		super();
		this.dialerId = dialerId;
		this.name = name;
		this.email = email;
		this.countryCode = countryCode;
		this.mobile1 = mobile1;
		this.mobile2 = mobile2;
		this.zip = zip;
		this.priority = priority;
		this.status = status;
		this.contactListId = contactListId;
	}

	public Integer getContactListId() {
		return contactListId;
	}

	public void setContactListId(Integer contactListId) {
		this.contactListId = contactListId;
	}

	public Integer getDialerId() {
		return dialerId;
	}

	public void setDialerId(Integer dialerId) {
		this.dialerId = dialerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile1() {
		return mobile1;
	}

	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public String getMobile2() {
		return mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@Override
	public String toString() {
		return "DialerDataEntity [dialerId=" + dialerId + ", name=" + name + ", email=" + email + ", countryCode="
				+ countryCode + ", mobile1=" + mobile1 + ", mobile2=" + mobile2 + ", zip=" + zip + ", priority="
				+ priority + ", status=" + status + ", contactListId=" + contactListId + "]";
	}

}
