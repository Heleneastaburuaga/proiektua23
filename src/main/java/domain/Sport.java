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

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Sport implements Serializable{
	@XmlID
	@Id 
	private String izena;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Vector<Event> events=new Vector<Event>();
	
	private Integer apustuKantitatea;
	
	public Sport() {
		super();
	}
	
	public Sport(String izena) {
		this.izena=izena;
		this.apustuKantitatea=0;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public Vector<Event> getEvents() {
		return events;
	}

	public void setEvents(Vector<Event> events) {
		this.events = events;
	}

	public Integer getApustuKantitatea() {
		return apustuKantitatea;
	}

	public void setApustuKantitatea(Integer apustuKantitatea) {
		this.apustuKantitatea = apustuKantitatea;
	}
	
	public void eguneratuApustuKantitatea() {
		this.apustuKantitatea=this.apustuKantitatea+1;
	}
	
	public void addEvent(Event ev) {
		this.events.add(ev);
	}
	

	@Override
	public String toString() {
		return this.izena;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o==null) {
			return false;
		}
		if(this.getClass() != o.getClass()) {
			return false;
		}
		Sport sp = (Sport) o;
		if(sp.getApustuKantitatea() == null) {
			return false;
		}
		return this.izena.equals(sp.getIzena());
	}
	
	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + apustuKantitatea;
	    return result;
	}
	
}
