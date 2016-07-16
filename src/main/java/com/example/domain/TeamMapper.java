package com.example.domain;

import java.util.List;

public interface TeamMapper {
	public List<Team> findAll();
	public Team findOne(int id);
	public Team findById(int id);
	public Team findByName(String name);
	public void insert(Team t);
	public void delete(int teamId);
	public void deleteByName(String teamName);
}
