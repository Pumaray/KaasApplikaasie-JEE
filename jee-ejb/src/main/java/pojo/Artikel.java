package pojo;

import java.math.BigDecimal;

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
@Table(name = "ARTIKEL")
@XmlRootElement(name = "artikel")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = "Artikel.findAll", query = "SELECT a FROM Artikel a")
public class Artikel {

	/*
	 * @Id
	 * 
	 * @GeneratedValue(generator = "InvTab")
	 * 
	 * @TableGenerator(name = "InvTab", table = "ID_GEN", pkColumnName =
	 * "ID_NAME", valueColumnName = "ID_VAL", pkColumnValue = "INV_GEN")
	 */
	@TableGenerator(name = "kaasapp_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 100)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "kaasapp_gen")
	private long id;

	@Column(name = "NAAM")
	@XmlAttribute(name = "naam")
	private String naam;

	@Column(name = "PRIJS")
	@XmlAttribute(name = "prijs")
	private BigDecimal prijs;

	@Column(name = "VOORRAAD")
	@XmlAttribute(name = "prijs")
	private Integer voorraad;

	protected Artikel() {
	}

	public Artikel(String naam, BigDecimal prijs, Integer voorraad) {
		this.naam = naam;
		this.prijs = prijs;
		this.voorraad = voorraad;
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

	public BigDecimal getPrijs() {
		return prijs;
	}

	public Integer getVoorraad() {
		return voorraad;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
	}

	public void setVoorraad(Integer voorraad) {
		this.voorraad = voorraad;
	}

	@Override
	public String toString() {
		return "Artikel [id=" + id + ", naam=" + naam + ", prijs=" + prijs
				+ ", voorraad=" + voorraad + "]";
	}
}
