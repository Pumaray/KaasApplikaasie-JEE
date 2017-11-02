package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;

import pojo.Artikel;

/**
 * Session Bean implementation class ArtikelDaoImpl
 */
@Stateless
@LocalBean
public class ArtikelDaoImpl implements ArtikelDao {

	@PersistenceContext // (unitName = "rsvier-pu", type =
						// PersistenceContextType.EXTENDED)
	private EntityManager database;

	@Inject
	private Logger logger;

	/**
	 * Default constructor.
	 */
	public ArtikelDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Artikel> findAll() {
		return database.createNamedQuery("Artikel.findAll", Artikel.class)
				.getResultList();
	}

	@Override
	public Artikel findById(long id) {
		return database.find(Artikel.class, id);
	}

	@Override
	public List<Artikel> findByName(String naam) {
		return database
				.createQuery("SELECT Artikel a FROM a WHERE a.naam=:naam",
						Artikel.class)
				.setParameter("naam", naam)
				.getResultList();
	}

	@Override
	public Artikel insert(Artikel artikel) throws Exception {
		try {
			database.persist(artikel);
			return artikel;
		}
		catch (Exception ex) {
			logger.error("Error inserting Artikel to database", ex);
			throw(ex);
		}
	}

	@Override
	public Artikel update(Artikel artikel) throws Exception {
		try {
			database.merge(artikel);
			return artikel;
		}
		catch (Exception ex) {
			logger.error("Error updating Artikel to database", ex);
			throw(ex);
		}
	}

	@Override
	public boolean delete(Artikel artikel) throws Exception {
		try {
			//database.remove(artikel);
			database.remove(database.contains(artikel) ? artikel : database.merge(artikel));
			return true;
		}
		catch (Exception ex) {
			logger.error("Error deleting Artikel to database", ex);
			throw(ex);
		}
	}

}
