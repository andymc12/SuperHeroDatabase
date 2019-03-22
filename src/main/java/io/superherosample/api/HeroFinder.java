package io.superherosample.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.eclipse.microprofile.graphql.Argument;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import io.superherosample.db.DuplicateSuperHeroException;
import io.superherosample.db.HeroDatabase;
import io.superherosample.db.UnknownTeamException;
import io.superherosample.model.SuperHero;
import io.superherosample.model.Team;

@GraphQLApi
public class HeroFinder {
	@Inject
	HeroDatabase heroDB;

	@Query
	public Collection<SuperHero> allHeroes() {
		return heroDB.getAllHeroes();
	}
	
	@Query
	public Collection<SuperHero> allHeroesIn(@Argument("city") String city) {
		return allHeroesByFilter(hero -> { return city.equals(hero.getPrimaryLocation());});
	}
	
	@Query
	public Collection<SuperHero> allHeroesWithPower(@Argument("power") String power) {
		return allHeroesByFilter(hero -> { return hero.getSuperPowers().contains(power);});
	}

	@Query
	public Collection<SuperHero> allHeroesInTeam(@Argument("team") String teamName) throws UnknownTeamException {
		return heroDB.getTeam(teamName).getMembers();
	}

	@Query
	public Collection<Team> allTeams() {
		return heroDB.getAllTeams();
	}
	@Mutation
	public SuperHero createNewHero(@Argument("hero") SuperHero newHero) throws DuplicateSuperHeroException {
		heroDB.addHero(newHero);
		return heroDB.getHero(newHero.getName());
	}

	@Mutation(description="Adds a hero to the specified team and returns the updated team.")
	public Team addHeroToTeam(@Argument("hero") String heroName, 
			                  @Argument("team") String teamName)
							  throws UnknownTeamException {
		
		return heroDB.getTeam(teamName)
				     .addMembers( heroDB.getHero(heroName) );
	}

	@Mutation(description="Removes a hero to the specified team and returns the updated team.")
	public Team removeHeroFromTeam(@Argument("hero") String heroName, 
			                       @Argument("team") String teamName)
							       throws UnknownTeamException {
		
		return heroDB.getTeam(teamName)
				     .removeMembers( heroDB.getHero(heroName) );
	}

	private Collection<SuperHero> allHeroesByFilter(Predicate<SuperHero> predicate) {
		return heroDB.getAllHeroes()
                     .stream()
                     .filter(predicate)
                     .collect(Collectors.toCollection(ArrayList::new));
	}
}
