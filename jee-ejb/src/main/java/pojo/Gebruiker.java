package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "GEBRUIKER")
@XmlRootElement(name = "gebruiker")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name="Gebruiker.findAll", query="SELECT g FROM Gebruiker g") 
public class Gebruiker {

	@TableGenerator(name = "kaasapp_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 100)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "kaasapp_gen")
	private long id;

	@Column(name = "NAAM")
	@XmlAttribute(name="naam")
	private  String naam;

	@Column(name = "WACHTWOORD")
	@XmlAttribute(name="wachtwoord")
	private  char[] wachtwoord;

	@Column(name = "GEGEVENS")
	@XmlAttribute(name="klant-gegevens")
	private  KlantGegevens gegevens;
	
	protected Gebruiker() {}

	public Gebruiker(String naam, char[] wachtwoord, KlantGegevens gegevens) {
		this.naam = naam;
		this.wachtwoord = wachtwoord;
		this.gegevens = gegevens;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public char[] getWachtwoord() {
		return wachtwoord;
	}

	public KlantGegevens getGegevens() {
		return gegevens;
	}

}
