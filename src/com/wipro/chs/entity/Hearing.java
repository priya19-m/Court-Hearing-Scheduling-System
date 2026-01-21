package com.wipro.chs.entity;

public class Hearing {
	private String hearingId;
	private String caseId;
	private String judgeId;
	private String roomId;
	private String date;
	private String timeSlot;
	public Hearing(String hearingId, String caseId, String judgeId, String roomId, String date, String timeSlot) {
		this.hearingId=hearingId;
		this.caseId=caseId;
		this.judgeId=judgeId;
		this.roomId=roomId;
		this.date=date;
		this.timeSlot=timeSlot;
	}
	public String getHearingId() {
		return hearingId;
	}
	public String getCaseId() {
		return caseId;
	}
	public String getJudgeId() {
		return judgeId;
	}
	public String getRoomId() {
		return roomId;
	}
	public String getDate() {
		return date;
	}
	public String getTimeSlot() {
		return timeSlot;
	}
}
