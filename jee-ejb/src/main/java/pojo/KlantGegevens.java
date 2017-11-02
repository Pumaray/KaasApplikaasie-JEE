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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "KLANTGEGEVENS")
@XmlRootElement(name = "klant-gegevens")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name="KlantGegevens.findAll", query="SELECT g FROM KlantGegevens g") 
public class KlantGegevens {

	@TableGenerator(name = "kaasapp_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 100)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "kaasapp_gen")
	private long id;

	@Column(name = "VOORNAAM")
	private String voornaam;

	@Column(name = "ACHTERNAAM")
	private String achternaam;

	@Column(name = "TUSSENVOEGSEL")
	private String tussenvoegsel;

	@Column(name = "ADRES")
	private Adres adres;

	@Column(name = "POSTADDRESS")
	private String postAdres;

	protected KlantGegevens() {
	}

	public KlantGegevens(String voornaam, String achternaam,
			String tussenvoegsel, Adres adres, String postAdres) {
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.tussenvoegsel = tussenvoegsel;
		this.adres = adres;
		this.postAdres = postAdres;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public Adres getAdres() {
		return adres;
	}

	public String getPostAdres() {
		return postAdres;
	}

	public static class GegevensBuilder {
		private String voornaam;
		private String achternaam;
		private String tussenvoegsel;
		private Adres adres;
		private String postAdres;

		public GegevensBuilder() {
		}

		public GegevensBuilder voornaam(String voornaam) {
			this.voornaam = voornaam;
			return this;
		}

		public GegevensBuilder achternaam(String achternaam) {
			this.achternaam = achternaam;
			return this;
		}

		public GegevensBuilder tussenvoegsel(String tussenvoegsel) {
			this.tussenvoegsel = tussenvoegsel;
			return this;
		}

		public GegevensBuilder adres(Adres adres) {
			this.adres = adres;
			return this;
		}

		public GegevensBuilder postAdres(String postAdres) {
			this.postAdres = postAdres;
			return this;
		}

		public KlantGegevens createGegevens() {
			return new KlantGegevens(voornaam, achternaam, tussenvoegsel, adres,
					postAdres);
		}

	}
}
