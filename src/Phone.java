
public class Phone extends Device {

	public String phoneOwner;
	public String phoneLocation; 
	public String gpsLong;
	public String gpsLat;
	
	
	public String getPhoneOwner() {
		return phoneOwner;
	}


	public void setPhoneOwner(String phoneOwner) {
		this.phoneOwner = phoneOwner;
	}


	public String getPhoneLocation() {
		return phoneLocation;
	}


	public void setPhoneLocation(String phoneLocation) {
		this.phoneLocation = phoneLocation;
	}


	public String getGpsLong() {
		return gpsLong;
	}


	public void setGpsLong(String gpsLong) {
		this.gpsLong = gpsLong;
	}


	public String getGpsLat() {
		return gpsLat;
	}


	public void setGpsLat(String gpsLat) {
		this.gpsLat = gpsLat;
	}


	public Phone[] getApps() {
		return apps;
	}


	public void setApps(Phone[] apps) {
		this.apps = apps;
	}


	public Phone[] apps;
	
	
}
