
import java.text.*;  // to get DecimalFormat

/** Represents a City */
class City{
    /** Decimal format to print leading zeros in zip code */
    DecimalFormat zipFormat = new DecimalFormat("00000");

    int zip;
    String name;
    String state;
    double longitude;
    double latitude;

    
    /** The full constructor */
    public City (int zip, String name, String state, double longitude, double latitude){
        this.zip   = zip;
        this.name  = name;
        this.state = state;
        this.longitude = longitude;
        this.latitude  = latitude;
    }    

    /** Represent  city data as a String for printed display */
    public String toString(){
        return ("new City(" + 
                this.zipFormat.format(this.zip) + ", " + 
                this.name  + ", " + this.state + ", " + 
                this.longitude + ", " + this.latitude + ")");
    }
}
