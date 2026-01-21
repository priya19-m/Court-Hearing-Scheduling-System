package com.wipro.chs.entity;

public class Case {
	private String caseId;
	private String caseTitle;
	private String petitioner;
	private String respondent;
	public Case(String caseId, String caseTitle, String petitioner, String respondent) {
		this.caseId=caseId;
		this.caseTitle=caseTitle;
		this.petitioner=petitioner;
		this.respondent=respondent;
	}
	public String getCashId() {
		return caseId;
	}
	public String getCashTitle() {
		return caseTitle;
	}
	public String getPetitioner() {
		return petitioner;
	}
	public String getRespondent() {
		return respondent;
	}
}
