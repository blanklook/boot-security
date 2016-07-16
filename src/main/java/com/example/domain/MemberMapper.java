package com.example.domain;

import java.util.List;

public interface MemberMapper {
	public String getTime();
	public Member findOne(int id);
	public List<Member> findAll();
	public List<MemberStatistics> statistics();
	public void insert(Member m);
	public void delete(int id);
}