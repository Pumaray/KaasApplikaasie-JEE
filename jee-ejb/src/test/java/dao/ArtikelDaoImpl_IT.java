package dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import pojo.Artikel;
import utils.LoggerProducer;

@RunWith(Arquillian.class)
public class ArtikelDaoImpl_IT {

	@EJB
	private ArtikelDaoImpl manager;

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, "arquillian-example.war")
				.addClass(LoggerProducer.class)
				.addClass(Artikel.class)
				.addClass(ArtikelDao.class)
				.addClass(ArtikelDaoImpl.class)
				.addAsResource("META-INF/test-beans.xml",
						"META-INF/beans.xml")
				.addAsResource("META-INF/test-persistence.xml",
						"META-INF/persistence.xml");
	}

	private Artikel generateArtikel(int index) {
		return new Artikel("Artikel " + index, new BigDecimal("5.0"), index);
	}

	@Test
	public void testInsert() {
		try {
			manager.insert(generateArtikel(1));
		}
		catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	@Test
	public void testUpdate() {
		try {
			final String NEW_NAAM = "NEW ARTIKEL NAAM";
			Artikel artikel = generateArtikel(2);
			manager.insert(artikel);
			artikel.setNaam("NEW ARTIKEL NAAM");
			manager.update(artikel);
			assertTrue(manager.findById(artikel.getId()).getNaam().equals(NEW_NAAM));

		}
		catch (Exception ex) {
			fail(ex.getMessage());
		}
	}
	
	@Test
	public void testDelete() {
		try {
			Artikel artikel = generateArtikel(2);
			manager.insert(artikel);
			assertTrue(manager.findById(artikel.getId())!= null);
			manager.delete(artikel);
			assertTrue(manager.findById(artikel.getId()) == null);
		}
		catch(Exception ex) {
			
		}
	}

}
