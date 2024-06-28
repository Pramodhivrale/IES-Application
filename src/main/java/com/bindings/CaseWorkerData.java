package com.bindings;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CaseWorkerData {

	private String fullName;

	private String emailId;

	private Long mobileNumber;

	private String gender;

	private String accountStatus;
	
	private Long ssn;

}
