
public class City {
	int id;
    int x;
    int y;

    public City(int id, int x, int y){
        this.id = id;
    	this.x = x;
        this.y = y;
    }

    // gets city's x coordinate
    public int getX(){
        return this.x;
    }

    // gets city's y coordinate
    public int getY(){
        return this.y;
    }
    
    // gets city's ID
    public int getID(){
    	return this.id;
    }

    // gets the distance to given city
    public double distanceTo(City city){
        int xDistance = Math.abs(getX() - city.getX());
        int yDistance = Math.abs(getY() - city.getY());
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
        
        return distance;
    }

   
    @Override
    public String toString(){
        return getX()+", "+getY();
    }

}