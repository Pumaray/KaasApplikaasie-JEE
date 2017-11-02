package pojo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ORDER")
@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o")
public class Order {

	@TableGenerator(name = "kaasapp_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 100)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "kaasapp_gen")
	private long id;

	@XmlAttribute(name = "artikel")
	@OneToOne(optional = false)
	@JoinColumn(name = "ARTIKEL_ID")
	private Artikel artikel;

	@Column(name = "AANTAL")
	@XmlAttribute(name = "aantal")
	private int aantal;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bestellingId")
	private Bestelling bestelling;

	protected Order() {
	}

	public Order(Artikel artikel, int aantal) {
		super();
		this.artikel = artikel;
		this.aantal = aantal;
	}

	public BigDecimal totaal() {
		return artikel.getPrijs().multiply(new BigDecimal(aantal));
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Artikel getArtikel() {
		return artikel;
	}

	public int getAantal() {
		return aantal;
	}

}
