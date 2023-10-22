package domain;

import java.util.Vector;


public class ApustuDataAccess {
	private Vector<Quote> quote = new Vector<Quote>();
	private double balioa;
	private int apustuBikoitzaGalarazi;
	private Registered user;
	private ApustuAnitza apustuAnitza;
	
	
	public ApustuDataAccess(Vector<Quote> quote, double balioa,int apustuBikoitzaGalarazi,
			Registered user,ApustuAnitza apustuAnitza) {
		this.quote=quote;
		this.balioa=balioa;
		this.apustuBikoitzaGalarazi=apustuBikoitzaGalarazi;
		this.user=user;
		this.apustuAnitza=apustuAnitza;
	}


	public Vector<Quote> getQuote() {
		return quote;
	}


	public void setQuote(Vector<Quote> quote) {
		this.quote = quote;
	}


	public double getBalioa() {
		return balioa;
	}


	public void setBalioa(double balioa) {
		this.balioa = balioa;
	}


	public int getApustuBikoitzaGalarazi() {
		return apustuBikoitzaGalarazi;
	}


	public void setApustuBikoitzaGalarazi(int apustuBikoitzaGalarazi) {
		this.apustuBikoitzaGalarazi = apustuBikoitzaGalarazi;
	}


	public Registered getUser() {
		return user;
	}


	public void setUser(Registered user) {
		this.user = user;
	}


	public ApustuAnitza getApustuAnitza() {
		return apustuAnitza;
	}


	public void setApustuAnitza(ApustuAnitza apustuAnitza) {
		this.apustuAnitza = apustuAnitza;
	}
	
	

}
