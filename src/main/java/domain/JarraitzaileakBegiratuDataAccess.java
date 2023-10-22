package domain;

import java.util.Vector;

public class JarraitzaileakBegiratuDataAccess {
	private Vector<Quote> quote = new Vector<Quote>();
	private Double balioa ;
	private Integer apustuBikoitzaGalarazi;
	private Registered user;
	private ApustuAnitza apustuAnitza;
	
	public JarraitzaileakBegiratuDataAccess( Vector<Quote> quote,  Double balioa, Integer apustuBikoitzaGalarazi,
		 Registered user,  ApustuAnitza apustuAnitza) {
		this.quote=quote;
		this.balioa= balioa;
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

	public Double getBalioa() {
		return balioa;
	}

	public void setBalioa(Double balioa) {
		this.balioa = balioa;
	}

	public Integer getApustuBikoitzaGalarazi() {
		return apustuBikoitzaGalarazi;
	}

	public void setApustuBikoitzaGalarazi(Integer apustuBikoitzaGalarazi) {
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
