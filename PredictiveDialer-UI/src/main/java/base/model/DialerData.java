package base.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
	private Integer contactListId;

}
