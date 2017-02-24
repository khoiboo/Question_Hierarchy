package GeoC_QuestionHierarchy;

public class Rank {
	double level;
	double weight;
	
	public Rank(double predefinedLevel, double predefinedWeight )
	{
		this.level = predefinedLevel;
		this.weight = predefinedWeight;		
	}
	
	public double getLevel()    { return this.level; }
	public double getWeight()   { return this.weight; }

}
