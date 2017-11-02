package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;

import pojo.Bestelling;

/**
 * Session Bean implementation class BestellingDaoImpl
 */
@Stateless
@LocalBean
public class BestellingDaoImpl implements BestellingDao {

	@PersistenceContext // (unitName = "rsvier-pu", type =
	// PersistenceContextType.EXTENDED)
	private EntityManager database;

	@Inject
	private Logger logger;

	/**
	 * Default constructor.
	 */
	public BestellingDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Bestelling> findAll() {
		return database.createNamedQuery("Bestelling.findAll", Bestelling.class)
				.getResultList();
	}

	@Override
	public Bestelling findById(long id) {
		return database.find(Bestelling.class, id);
	}

	@Override
	public long insert(Bestelling bestelling) {
		try {
			database.persist(bestelling);
			return bestelling.getBestellingId();
		}
		catch (Exception ex) {
			logger.error("Error saving Bestelling", ex);
			throw (ex);
		}
	}

	@Override
	public long update(Bestelling bestelling) {
		try {
			database.merge(bestelling);
			return bestelling.getBestellingId();
		}
		catch (Exception ex) {
			logger.error("Error saving Bestelling", ex);
			throw (ex);
		}
	}

	@Override
	public void delete(Bestelling bestelling) {
		try {
			database.remove(database.contains(bestelling) ? bestelling
					: database.merge(bestelling));
		}
		catch (Exception ex) {
			logger.error("Error saving Bestelling", ex);
			throw (ex);
		}
	}

}
