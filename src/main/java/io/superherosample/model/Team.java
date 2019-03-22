package io.superherosample.model;

import java.util.List;

public class Team {


	String name;
	List<SuperHero> members;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<SuperHero> getMembers() {
		return members;
	}
	public void setMembers(List<SuperHero> members) {
		this.members = members;
	}
	public Team addMembers(SuperHero...heroes) {
		for (SuperHero hero : heroes) {
			members.add(hero);
		}
		return this;
	}
	public Team removeMembers(SuperHero...heroes) {
		for (SuperHero hero : heroes) {
			members.remove(hero);
		}
		return this;
	}
}
