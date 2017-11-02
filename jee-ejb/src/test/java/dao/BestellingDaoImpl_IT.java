package dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import pojo.Artikel;
import pojo.Bestelling;
import pojo.Order;
import utils.LoggerProducer;

@RunWith(Arquillian.class)
public class BestellingDaoImpl_IT {

	@EJB
	private BestellingDaoImpl manager;

	@EJB
	private ArtikelDaoImpl artikelManager;

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, "arquillian-example.war")
				.addClass(LoggerProducer.class)
				.addClass(Artikel.class)
				.addClass(ArtikelDao.class)
				.addClass(ArtikelDaoImpl.class)
				.addClass(Order.class)
				.addClass(Bestelling.class)
				.addClass(BestellingDao.class)
				.addClass(BestellingDaoImpl.class)
				.addAsResource("META-INF/test-beans.xml",
						"META-INF/beans.xml")
				.addAsResource("META-INF/test-persistence.xml",
						"META-INF/persistence.xml");
	}

	private Bestelling generateBestelling(int index) throws Exception {
		Set<Order> orders = new HashSet<Order>();
		for (int i = 0; i < index; i++) {
			Artikel artikel = new Artikel("Artikel " + index,
					new BigDecimal("5.0").multiply(new BigDecimal(index)),
					index);
			artikelManager.insert(artikel);
			orders.add(new Order(artikel, index));
		}
		return new Bestelling(orders);
	}

	@Test
	public void testInsert() {
		try {
			manager.insert(generateBestelling(1));
		}
		catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	// @Test
	public void testUpdate() {
		try {

		}
		catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	// @Test
	public void testDelete() {
		try {
		}
		catch (Exception ex) {

		}
	}
}