package io.superherosample.model;

import java.util.List;

public class SuperHero {

	List<Team> teamAffiliations;
	List<String> superPowers;
	String primaryLocation;
	String name;
	String realName;

	public List<Team> getTeamAffiliations() {
		return teamAffiliations;
	}
	public void setTeamAffiliations(List<Team> teamAffiliations) {
		this.teamAffiliations = teamAffiliations;
	}
	public List<String> getSuperPowers() {
		return superPowers;
	}
	public void setSuperPowers(List<String> superPowers) {
		this.superPowers = superPowers;
	}
	public String getPrimaryLocation() {
		return primaryLocation;
	}
	public void setPrimaryLocation(String primaryLocation) {
		this.primaryLocation = primaryLocation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
}
