package GeoC_QuestionHierarchy;

public class WifiNetwork {
	
	String SSID;
	String BSSID;
	int signalStrength;
	
	public WifiNetwork (String SSID_Value, String BSSID_Value, int signalStrength_Value)
	{
		this.SSID = SSID_Value;
		this.BSSID = BSSID_Value;
		this.signalStrength = signalStrength_Value;		
	}
	
	public String getSSID() { return this.SSID; }
	public String getBSSID() { return this.BSSID; }
	public int getSignalStrength() { return this.signalStrength; }

}
