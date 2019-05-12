
public class SimCard 
{

	private int iccid;
	
	private String imsi;
	private String secretkey;
	private String puk;
	private String challenge;
	private String response;
	public int getIccid() {
		return iccid;
	}
	public void setIccid(int iccid) {
		this.iccid = iccid;
	}
	public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	public String getSecretkey() {
		return secretkey;
	}
	public void setSecretkey(String secretkey) {
		this.secretkey = secretkey;
	}
	public String getPuk() {
		return puk;
	}
	public void setPuk(String puk) {
		this.puk = puk;
	}
	public String getChallenge() {
		return challenge;
	}
	public void setChallenge(String challenge) {
		this.challenge = challenge;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	

}
