package GeoC_QuestionHierarchy;

import java.util.List;

public class Participant {
	
	String userID;
	double expPoint;
	double money;
	double nextRank;
	List<String> prize;
	
	public Participant(String str, double point, double nRank, double realmoney, List<String> prizeGained)
	{
		this.userID = str;
		this.expPoint = point;
		this.nextRank = nRank;
		this.money = realmoney;
		this.prize = prizeGained;
	}
	
	public String getUserID() 				{ return this.userID;}
	public double getExPPoint() 			{ return this.expPoint;}
	public double getNextRank() 			{ return this.nextRank;}
	public double getMoney() 				{ return this.money; }
	public List<String> getListPrize() 		{return this.prize; }
	
}
