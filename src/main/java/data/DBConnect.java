package data;

import java.util.*;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.sun.javafx.scene.control.Properties;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.List;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.*;
import static com.sun.javafx.reflect.FieldUtil.getField;

public class DBConnect{
    private MongoClient client;
    private MongoDatabase db;

    private MongoCollection<Document> restaurants;
    public DBConnect(){
        try{
            client = new MongoClient("localhost", 27017);
            db = client.getDatabase("restaurants");
            restaurants = db.getCollection("restaurants");
        }
        catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    public void closeDbConnect(){
        client.close();
    }

    public List<String> getBoroughs(){
        List<String> boroughs = new ArrayList<String>();
        String data;
        try{


            Bson projection = fields(include("borough"), exclude("_id"));

            FindIterable<Document> iterable = restaurants.find().projection(projection).sort(ascending("borough"));
            MongoCursor<Document> cursor = iterable.iterator();

            // Iterate over the cursor and process the documents
            while (cursor.hasNext()) {
                data = cursor.next().get("borough").toString();
                if(!boroughs.contains(data)) {
                    boroughs.add(data);
                }
            }
        }
        catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return boroughs;
    }

    public List<String> getCuisine(String borough){
        List<String> cuisines_borough = new ArrayList<String>();
        String data;
        try{
            // Create a query
            Bson equalComparison = eq("borough", borough);
            Bson projection = fields(include("cuisine"), exclude("_id"));

            FindIterable<Document> iterable = restaurants.find(equalComparison).projection(projection).sort(ascending("cuisine"));
            MongoCursor<Document> cursor = iterable.iterator();

            // Iterate over the cursor and process the documents
            while (cursor.hasNext()) {
                data = cursor.next().get("cuisine").toString();
                if(!cuisines_borough.contains(data)) {
                    cuisines_borough.add(data);
                }
            }
        }
        catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return cuisines_borough;
    }

    public List<Restaurants> getRestaurants(String borough, String cuisine) {
        List<Restaurants> user_restaurants = new ArrayList<>();
        List<String> check_id = new ArrayList<>();
        Document data;
        try {
            Bson match1 = Aggregates.match(eq("borough", borough));
            Bson match2 = Aggregates.match(eq("cuisine", cuisine));
            Bson unwind_grades = Aggregates.unwind("$grades");
            Bson unwind_address = Aggregates.unwind("$address");
            Bson group = Aggregates.group("$_id", Accumulators.avg("avg_grade", "$grades.score"),
                    Accumulators.push("info", Document
                            .parse("{ 'name': '$name',  " +
                                    "'borough': '$borough',  " +
                                    "'cuisine': '$cuisine', " +
                                    "'building': '$address.building'," +
                                    "'street': '$address.street'  }")));
            Bson unwind_info = Aggregates.unwind("$info");
            Bson project = Aggregates.project(fields(include("avg_grade"),
                    computed("name", "$info.name"),
                    computed("borough", "$info.borough"),
                    computed("cuisine", "$info.cuisine"),
                    computed("street", "$info.street"),
                    computed("building", "$info.building")));
            Bson sort = Aggregates.sort(descending("avg_grade"));

            List<Document> results = restaurants.aggregate(List.of(
                    match1, match2, unwind_grades, unwind_address, group, unwind_info, project, sort)).into(new ArrayList<>());


            for (int i = 0; i < results.size(); i += 1) {
                data = results.get(i);
                if (!check_id.contains(data.get("_id").toString())){
                    check_id.add(data.get("_id").toString());

                    String _name = data.get("name").toString();
                    int _score = Math.round(Float.parseFloat(data.get("avg_grade").toString()));
                    String _borough = data.get("borough").toString();
                    String _cuisine = data.get("cuisine").toString();
                    String _street = data.get("street").toString();
                    String _building = data.get("building").toString();
                    Restaurants restik = new Restaurants(_name, _score, _borough, _cuisine, _street, _building);
                    user_restaurants.add(restik);
                }
            }
        }
        catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return user_restaurants;
    }
}
