# SuperHeroDatabase
MP GraphQL Sample

This project is intended to show how easy it is to develop a GraphQL-based application using the MicroProfile GraphQL APIs.

The project itself will generate a WAR file that can act as an online database for comic book super heroes.
The WAR file must be deployed in a container that implements the (still under development) MicroProfile GraphQL specification.
Because the spec is still evolving, the only containers that can be used to implement the spec are prototypes.
One such prototype, based on [Open Liberty](http://openliberty.io) is available here:

https://drive.google.com/open?id=137Pd86OfIuiyRbHXUZn59IqHiTFKUS82

If you download the [superHeroServer.jar](https://drive.google.com/file/d/1TSCAAifGM9mjEVlLVJEtIOR9wSrjNki0/view?usp=sharing) file, you can run the sample with:

`java -jar superHeroServer.jar`

Once you see the following message, you can invoke the GraphQL service:

`[AUDIT   ] CWWKF0011I: The server superHeroServer is ready to run a smarter planet.`

Next, point your browser to http://localhost:9080/MPGraphQLSample/graphiql.html

At this point, you should be able to query superheroes (there are a few built-in to the database) with queries like:
```
query allHeroes {allHeroes {
  name
  primaryLocation
  superPowers
  realName
}}
```

```
query allAvengers {allHeroesInTeam(team:"Avengers") {
  name
  primaryLocation
  superPowers
}}
```

or you can add your own superheroes with a mutation like:
```
mutation createNewHero {createNewHero(hero:
  {
    name: "Captain America"
   	realName: "Steven Rogers"
    superPowers: ["Super strength", "Vibranium Shield"]
    primaryLocation: "New York, NY"
    teamAffiliations: [{name:"Avengers"}]
   }) {
  name
  primaryLocation
  superPowers
  realName
}}
```

or add a superhero to another team like:
```
mutation addHeroToTeam {addHeroToTeam(hero: "Starlord", team: "Avengers") {
  name
  members {
    name
  }
}}
```

There is a lot of power in GraphQL, and the MicroProfile GraphQL project intends to make it easy to harness that power.
Check out the source code of this application - there's not a lot! 

This project is evolving, just like the MP GraphQL project itself, so please be patient if you run into issues, and please report them - better yet, please join the [MicroProfile Community](http://microprofile.io).  Thanks!
