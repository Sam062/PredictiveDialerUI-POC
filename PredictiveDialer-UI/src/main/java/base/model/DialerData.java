package base.model;

public class DialerData {

	private Integer dialerId;
	private String name;
	private String email;
	private String countryCode;
	private String mobile1;
	private String mobile2;
	private String zip;
	private Integer priority;
	private String status;

	public DialerData() {
		super();
	}

	public DialerData(Integer dialerId, String name, String email, String countryCode, String mobile1, String mobile2,
			String zip, Integer priority, String status) {
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

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
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

}
