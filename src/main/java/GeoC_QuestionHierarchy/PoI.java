package GeoC_QuestionHierarchy;

public class PoI {
	double lat;
	double lon;
	double radius;
	
	public PoI(double lat_input, double lon_input, double radius_input)
	{
		this.lat = lat_input;
		this.lon = lon_input;
		this.radius = radius_input;
	}
	
	public double getLat()        {return this.lat;}
	public double getLong()       {return this.lon;}
	public double getRadius()     {return this.radius;}

}
