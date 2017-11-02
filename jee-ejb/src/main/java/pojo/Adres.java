package pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Embeddable
@XmlRootElement(name = "adres")
@XmlAccessorType(XmlAccessType.FIELD)
public class Adres {

	@Column(name = "STRAATNAME")
	@XmlAttribute(name="straatnaam")
	private  String straatNaam;

	@Column(name = "HUISNUMMER")
	@XmlAttribute(name="huisnummer")
	private int huisnummer;

	@Column(name = "HUISNUMMER-TOEVOEGING")
	@XmlAttribute(name="huisnummer-toevoeging")
	private String huisnummerToevoeging;

	@Column(name = "POSTCODE")
	@XmlAttribute(name="postcode")
	private String postcode;

	protected Adres() {}

	public Adres(String straatNaam, int huisnummer, String huisnummerToevoeging,
			String postcode) {
		this.straatNaam = straatNaam;
		this.huisnummer = huisnummer;
		this.huisnummerToevoeging = huisnummerToevoeging;
		this.postcode = postcode;
	}

	public String getStraatNaam() {
		return straatNaam;
	}

	public int getHuisnummer() {
		return huisnummer;
	}

	public String getHuisnummerToevoeging() {
		return huisnummerToevoeging;
	}

	public String getPostcode() {
		return postcode;
	}

}
