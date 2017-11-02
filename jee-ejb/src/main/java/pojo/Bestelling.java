package pojo;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "BESTELLING")
@XmlRootElement(name = "bestelling")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name="Bestelling.findAll", query="SELECT b FROM Bestelling b") 
public class Bestelling {

	@TableGenerator(name = "kaasapp_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 100)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "kaasapp_gen")
	private long bestellingId;

	@Column(name = "ORDERS")
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "bestelling",  targetEntity=Order.class)
	//@Size(min=1)
	private Set<Order> orders = new HashSet<Order>();

	@Column(name = "TOTAAL_PRIJS")
	@XmlAttribute(name="totaal-prijs")
	private BigDecimal totaalPrijs;
	
	protected Bestelling() {
	}

	public Bestelling(Set<Order> orders) {
		this.orders = orders;
	}
	
	private void updateTotaalPrice() {
		totaalPrijs = orders.stream()
		        .map(Order::totaal)
		        .reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public long getBestellingId() {
		return bestellingId;
	}

	public void setBestellingId(long bestellingId) {
		this.bestellingId = bestellingId;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
		updateTotaalPrice();
	}

	public BigDecimal getTotaalPrijs() {
		return totaalPrijs;
	}

}
