package com.example.domain;

import java.util.Date;

public class Member {
	int id;
	String homeCity;
	String homeStreet;
	String homeZipCode;
	String name;
	Date eDate;
	Date sDate;
	int teamId;
	
	Team team;
	
	public Member() {}

	public Member(String homeCity, String homeStreet, String homeZipCode, String name, Date eDate, Date sDate,
			int teamId) {
		this.homeCity = homeCity;
		this.homeStreet = homeStreet;
		this.homeZipCode = homeZipCode;
		this.name = name;
		this.eDate = eDate;
		this.sDate = sDate;
		this.teamId = teamId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}

	public String getHomeStreet() {
		return homeStreet;
	}

	public void setHomeStreet(String homeStreet) {
		this.homeStreet = homeStreet;
	}

	public String getHomeZipCode() {
		return homeZipCode;
	}

	public void setHomeZipCode(String homeZipCode) {
		this.homeZipCode = homeZipCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date geteDate() {
		return eDate;
	}

	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}

	public Date getsDate() {
		return sDate;
	}

	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", homeCity=" + homeCity + ", homeStreet=" + homeStreet + ", homeZipCode="
				+ homeZipCode + ", name=" + name + ", eDate=" + eDate + ", sDate=" + sDate + ", teamId=" + teamId + "]";
	}
}
