package com.example.domain;

public class MemberStatistics {
	
	String teamId;
	String teamName;
	
	int count;
	
	public MemberStatistics() {}

	public MemberStatistics(String teamId, String teamName, int count) {
		this.teamId = teamId;
		this.count = count;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "MemberStatistics [teamId=" + teamId + ", teamName=" + teamName + ", count=" + count + "]";
	}

}
