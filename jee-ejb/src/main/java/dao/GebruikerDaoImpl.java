package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import pojo.Gebruiker;

/**
 * Session Bean implementation class GebruikerDaoImpl
 */
@Stateless
@LocalBean
public class GebruikerDaoImpl implements GebruikerDao {

    /**
     * Default constructor. 
     */
    public GebruikerDaoImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Gebruiker> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gebruiker> findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gebruiker> findByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Gebruiker gebruiker) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Gebruiker gebruiker) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Gebruiker gebruiker) {
		// TODO Auto-generated method stub
		return false;
	}

}
