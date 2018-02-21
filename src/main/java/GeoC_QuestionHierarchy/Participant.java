package GeoC_QuestionHierarchy;

import java.util.List;

public class Participant {
	
	String userID;
	double expPoint;
	double money;
	double nextRank;
	List<String> prize;
	String rewardCode;
	double highestPoint;
	
	public Participant(String str, double point, double nRank, double realmoney, List<String> prizeGained, String codeValue, double highestPointValue)
	{
		this.userID = str;
		this.expPoint = point;
		this.nextRank = nRank;
		this.money = realmoney;
		this.prize = prizeGained;
		this.rewardCode = codeValue;
		this.highestPoint = highestPointValue;
	}
	
	public String getUserID() 				{ return this.userID;}
	public double getExPPoint() 			{ return this.expPoint;}
	public double getNextRank() 			{ return this.nextRank;}
	public double getMoney() 				{ return this.money; }
	public List<String> getListPrize() 		{ return this.prize; }
	public String getRewardCode()			{ return this.rewardCode; }
	public double getHighestPoint()			{ return this.highestPoint; }
	
}
