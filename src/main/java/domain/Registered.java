package domain;

import java.io.Serializable;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Registered  implements Serializable{
	
	@Id
	@XmlID
	private String usrname;
	private String password;
	private Integer bankAccount;
	private boolean isAdmin;
	
	
	private Double dirukop;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private Vector<Transaction> transakzioak; 
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private Vector<ApustuAnitza> apustuAnitzak; 
	private Double irabazitakoa;
	private int zenbat;
	private String mode;
	private Double diruLimitea;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Vector<Jarraitzailea> niriLista;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Vector<Jarraitzailea> nikLista;
	
	@XmlIDREF
	private Team taldea;

	public Registered(String username, String password, Integer bankAccount) {
		this.isAdmin=false;

		this.usrname=username;
		this.password=password;
		this.bankAccount=bankAccount;
		this.dirukop = 0.0; 
		this.transakzioak = new Vector<Transaction>();
		this.apustuAnitzak = new Vector<ApustuAnitza>();
		this.irabazitakoa=0.0;
		this.zenbat=0;
		this.mode=null;
		this.diruLimitea=0.0;
		this.nikLista= new Vector<Jarraitzailea>();
		this.niriLista= new Vector<Jarraitzailea>();
		this.taldea=null;
	}
	
	public Registered(String username, String password, Integer bankAccount, boolean isAdmin) {
		this(username,password,bankAccount);

		this.isAdmin=isAdmin;
	}
	public Registered() {
		super();
	}
	
	public Vector<Transaction> getTransakzioak() {
		return transakzioak;
	}

	public void setTransakzioak(Vector<Transaction> transakzioak) {
		this.transakzioak = transakzioak;
	}
	
	public Double getDirukop() {
		return dirukop;
	}

	public void setDirukop(Double dirukop) {
		this.dirukop = dirukop;
	}

	public Vector<ApustuAnitza> getApustuAnitzak() {
		return apustuAnitzak;
	}

	public void setApustuAnitzak(Vector<ApustuAnitza> apustuak) {
		this.apustuAnitzak = apustuak;
	}
	
	public Double getIrabazitakoa() {
		return irabazitakoa;
	}
	
	public void setIrabazitakoa(Double irabazitakoa) {
		this.irabazitakoa = irabazitakoa;
	}
	
	public int getZenbat() {
		return zenbat;
	}
	
	public void setZenbat(int zenbat) {
		this.zenbat = zenbat;
	}
	
	public String getMode() {
		return mode;
	}
	
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	public Double getDiruLimitea() {
		return diruLimitea;
	}
	
	public void setDiruLimitea(Double diruLimitea) {
		this.diruLimitea = diruLimitea;
	}
	
	public Vector<Jarraitzailea> getJarraitzaileLista() {
		return niriLista;
	}
	
	public void setJarraitzaileLista(Vector<Jarraitzailea> jarraitzaileLista) {
		this.niriLista = jarraitzaileLista;
	}
	
	public Vector<Jarraitzailea> getJarraitutakoLista() {
		return nikLista;
	}
	public void setJarraitutakoLista(Vector<Jarraitzailea> jarraitutakoLista) {
		this.nikLista = jarraitutakoLista;
	}
	public void addTransaction(Transaction t) {
		this.transakzioak.add(t); 
	}
	
	public void updateDiruKontua(Double z) {
		this.dirukop = this.dirukop + z; 
	}
	
	public void addApustuAnitza(ApustuAnitza a) {
		this.apustuAnitzak.add(a); 
	}
	
	public void removeApustua(ApustuAnitza a) {
		this.apustuAnitzak.remove(a);
	}
	
	public void addJarraitzailea(Jarraitzailea reg) {
		this.niriLista.add(reg);
	}
	
	public void addJarraitutako(Jarraitzailea reg) {
		this.nikLista.add(reg);
	}
	
	
	
	@Override
	public String toString() {
		if(this.mode.equals("RankingGUI"))
			return this.getUsername() + " " + this.zenbat +": " + this.irabazitakoa + "�";
		else
			return this.getUsername();
	}
	
	public Team getTaldea() {
		return taldea;
	}
	
	public void setTaldea(Team taldea) {
		this.taldea = taldea;
	}
	public String getUsername() {
		return usrname;
	}

	public void setUsername(String usrname) {
		this.usrname = usrname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(Integer bankAccount) {
		this.bankAccount = bankAccount;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	
}
