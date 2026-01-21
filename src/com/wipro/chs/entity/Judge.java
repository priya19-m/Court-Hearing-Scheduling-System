package com.wipro.chs.entity;

public class Judge {
	private String judgeId;
	private String judgeName;
	public Judge(String judgeId, String judgeName) {
		this.judgeId=judgeId;
		this.judgeName=judgeName;
	}
	public String getJudgeId() {
		return judgeId;
	}
	public String getJudgeName() {
		return judgeName;
	}
}
