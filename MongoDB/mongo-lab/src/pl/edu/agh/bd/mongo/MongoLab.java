package pl.edu.agh.bd.mongo;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.mongodb.*;

public class MongoLab {
	private MongoClient mongoClient;
	private DB db;
	
	public MongoLab() throws UnknownHostException {
		mongoClient = new MongoClient();
		db = mongoClient.getDB("jeopardy");
	}

	public static void simple_query(DBCollection coll){
		BasicDBObject query = new BasicDBObject("category","HISTORY");
		DBCursor cursor = coll.find(query);
		try{
			while(cursor.hasNext()){
				System.out.println(cursor.next());
			}
		}finally{
			cursor.close();
		}
	}

	public static void second_query(DBCollection coll){

		DBObject match = new BasicDBObject("$match", new BasicDBObject() );
		DBObject fields = new BasicDBObject("_id", 1);
		fields.put("date_min", 1);
		DBObject project = new BasicDBObject("$project", fields );

		DBObject groupOp = new BasicDBObject("_id","$category");
		groupOp.put("date_min", new BasicDBObject("$min", "$air_date"));
		DBObject group = new BasicDBObject("$group", groupOp);
		List<DBObject> pipe = Arrays.asList(match, project, group);
		//AggregationOptions options = AggregationOptions.builder().build();
		AggregationOutput out = coll.aggregate(pipe);
		for(DBObject o : out.results()){
			System.out.println(o);
		}
		//System.out.println(out.getCommandResult());
	}

	public static void third_query(DBCollection coll){
		String map = "function(){ "+
				"emit(this.air_date, this.value);}";
		String reduce = "function(key, values){ "+
				"return values.length}";
		MapReduceCommand cmd = new MapReduceCommand(coll, map, reduce, null, MapReduceCommand.OutputType.INLINE, null);
		MapReduceOutput out = coll.mapReduce(cmd);
		for(DBObject o : out.results()){
			System.out.println(o.toString());
		}
	}

	public static void main(String[] args) throws UnknownHostException {
		MongoLab mongoLab = new MongoLab();
		DBCollection coll = mongoLab.db.getCollection("question");
		//simple_query(coll);
		//second_query(coll);
		third_query(coll);
		mongoLab.mongoClient.close();
	}

}
