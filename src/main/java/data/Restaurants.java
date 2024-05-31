package data;

public class Restaurants {
    private String name;
    private int score;
    private String borough;
    private String cuisine;
    private String building;
    private String street;
    public Restaurants(String name, int score, String borough, String cuisine, String street, String building){
        this.name = name;
        this.score = score;
        this.borough = borough;
        this.cuisine = cuisine;
        this.street = street;
        this.building = building;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }
    public String getBorough(){
        return borough;
    }
    public String getCuisine(){
        return cuisine;
    }
    public String getStreet(){
        return street;
    }
    public String getBuilding(){
        return building;
    }

}
