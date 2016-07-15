package com.example.domain;

import java.util.List;

public interface MemberMapper {
	public String getTime();
	public List<Member> findAll();
	public List<MemberStatistics> statistics();
}
