package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import pojo.KlantGegevens;

/**
 * Session Bean implementation class KlantGegevensDaoImpl
 */
@Stateless
@LocalBean
public class KlantGegevensDaoImpl implements KlantGegevensDao {

    /**
     * Default constructor. 
     */
    public KlantGegevensDaoImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<KlantGegevens> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KlantGegevens> findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KlantGegevens> findByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(KlantGegevens klantGegevens) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(KlantGegevens klantGegevens) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(KlantGegevens klantGegevens) {
		// TODO Auto-generated method stub
		return false;
	}

}
