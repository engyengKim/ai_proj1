import java.util.ArrayList;

public class TourManager {
    // hold our cities
    private static ArrayList destinationCities = new ArrayList<City>();

    // add a destination city
    public static void addCity(City city) {
        destinationCities.add(city);
    }

    // get a city
    public static City getCity(int index){
        return (City)destinationCities.get(index);
    }
    
    
    // get the number of destination cities
    public static int numOfCities(){
        return destinationCities.size();
    }

}