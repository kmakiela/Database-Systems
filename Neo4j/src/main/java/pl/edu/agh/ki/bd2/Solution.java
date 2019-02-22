package pl.edu.agh.ki.bd2;

public class Solution {

    private final GraphDatabase graphDatabase = GraphDatabase.createDatabase();

    public void databaseStatistics() {
        System.out.println(graphDatabase.runCypher("CALL db.labels()"));
        System.out.println(graphDatabase.runCypher("CALL db.relationshipTypes()"));
    }

    public void runAllTests() {
        System.out.println(findActorByName("Emma Watson"));
        System.out.println(findMovieByTitleLike("Star Wars"));
        System.out.println(findRatedMoviesForUser("maheshksp"));
        System.out.println(findCommonMoviesForActors("Emma Watson", "Daniel Radcliffe"));
        System.out.println(findMovieRecommendationForUser("emileifrem"));
    }

    public void runAllAdditionalTests(){
        System.out.println(create_actor_movie_and_relation("Obama", "Crab Rave"));
        System.out.println(add_properties_to_actor("Obama","Kenia","01.01.1010"));
        System.out.println(find_actors_with_more_than_5_movies());
        System.out.println(count_avg_movies_for_actors_with_more_than_6_movies());
        System.out.println(find_actors_being_directors_as_well());
        System.out.println(find_good_movies_rated_by_friends("maheshksp"));
        System.out.println(find_path_without_movies("Obunga", "Obama")); //u mnie lokalnie dodałem relację FRIEND między tymi dwoma i wtedy działa
        System.out.println(compare_times());
    }

    private String findActorByName(final String actorName) {
        String actor = graphDatabase.runCypher("MATCH (a:Actor) WHERE a.name contains \"" + actorName + "\" return a");
        return actor;
    }

    private String findMovieByTitleLike(final String movieName) {
        String movie = graphDatabase.runCypher("MATCH (m:Movie) WHERE m.title contains \"" + movieName + "\" return m");
        return movie;
    }

    private String findRatedMoviesForUser(final String userLogin) {
        String rated = graphDatabase.runCypher("MATCH p = (u:User{login:\"" +userLogin + "\"}) -[:RATED]->(:Movie) return p");
        return rated;
    }

    private String findCommonMoviesForActors(String actorOne, String actorTwo) {
        String movies = graphDatabase.runCypher("MATCH (a:Actor)-[:ACTS_IN]-(m)-[:ACTS_IN]-(a2:Actor) where a.name contains \"" + actorOne + "\" and a2.name contains \"" + actorTwo + "\" return m");
        return movies;
    }

    private String findMovieRecommendationForUser(final String userLogin) {
        String movies = graphDatabase.runCypher("MATCH (m:Movie)-[:ACTS_IN]-(a:Actor)-[:ACTS_IN]-(m2:Movie)-[r:RATED]-(u:User{login:\"" + userLogin + "\"}) where r.stars > 4  return m");
        return movies;
    }

    //4
    private String create_actor_movie_and_relation(String actorName, String movieTitle){
        graphDatabase.runCypher("CREATE (a:Actor{name:\"" + actorName + "\"})");
        graphDatabase.runCypher("CREATE (m:Movie{title:\"" + movieTitle + "\"})");
        graphDatabase.runCypher("CREATE (n{name:\"" + actorName + "\"})-[a:ACTS_IN]->(m{title:\"" + movieTitle + "\"})");
        String proof = graphDatabase.runCypher("MATCH (n{name:\"" + actorName +"\"})-[a:ACTS_IN]->(m{title:\"" + movieTitle + "\"}) return n,a,m");
        return proof;
    }

    //5
    private String add_properties_to_actor(String actorName, String birthplace, String birthday){
        graphDatabase.runCypher("MATCH (a:Actor{name: \"" + actorName + "\"}) SET a.birthplace = \"" + birthplace + "\", a.birthday = \""+ birthday +"\"");
        String proof = graphDatabase.runCypher("MATCH (a:Actor{name: \"" + actorName + "\"}) return a");
        return proof;
    }

    //6
    private String find_actors_with_more_than_5_movies(){
        String actors = graphDatabase.runCypher("MATCH (m)-[a:ACTS_IN]-(n) with m, length(collect(n.title)) as number where number > 5  return m, number");
        return actors;
    }

    //7
    private String count_avg_movies_for_actors_with_more_than_6_movies(){
        String avg = graphDatabase.runCypher("MATCH (m)-[a:ACTS_IN]-(n) with m, length(collect(n.title)) as number where number > 6  return avg(number)");
        return avg;
    }

    //8
    private String find_actors_being_directors_as_well(){
        String actors = graphDatabase.runCypher("MATCH (o)<-[:DIRECTED]-(m)-[a:ACTS_IN]-(n) with m, length(collect(n.title)) as number where number > 4  return m , number ORDER BY number descending");
        return actors;
    }

    //9
    private String find_good_movies_rated_by_friends(String userName){
        String results = graphDatabase.runCypher("MATCH (u:User{login:\""+ userName +"\"})-[:FRIEND]-(f:User)-[r:RATED]-(m:Movie) WHERE r.stars > 2 RETURN f.name, m.title, r.stars");
        return results;
    }

    //10
    private String find_path_without_movies(String actorOne, String actorTwo){
        String path = graphDatabase.runCypher("MATCH path = (a{name:\""+ actorOne + "\"})-[*..30]->(a2{name:\"" + actorTwo + "\"})\n" +
                "WHERE NONE(n IN nodes(path) WHERE n:Movie)\n" +
                "RETURN path");
        return path;
    }

    //11
    private String compare_times(){
        String result = graphDatabase.runCypher("PROFILE MATCH (a:Actor{name:\"Keira Knightley\"}) return a");
        graphDatabase.runCypher("CREATE INDEX ON :Actor(name)");
        result += graphDatabase.runCypher("PROFILE MATCH (a:Actor{name:\"Keira Knightley\"}) return a");
        //times checked in browser, w/o index 21 ms with index 15 ms
        result += graphDatabase.runCypher("PROFILE MATCH p = shortestPath((a{name:\"Keira Knightley\"})-[*..20]-(b{name:\"Emma Watson\"})) return p");
        graphDatabase.runCypher("DROP INDEX ON :Actor(name)");
        result += graphDatabase.runCypher("PROFILE MATCH p = shortestPath((a{name:\"Keira Knightley\"})-[*..20]-(b{name:\"Emma Watson\"})) return p");
        //times checked in browser, w/o index 261 ms with index 139 ms
        return result;
    }

}
