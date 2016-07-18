package com.example.domain;

import java.util.List;

public interface MemberMapper {
	public String getTime();
	public Member findOne(int id);
	public Member findById(int id);
	public Member findOneByName(Member m);
	public List<Member> findAll();
	public List<Member> findAllByName(Member m);
	public List<MemberStatistics> statistics();
	public void insert(Member m);
	public void deleteById(Member m);
	public void delete(int id);
}