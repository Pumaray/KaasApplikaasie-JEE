package dao;

import java.util.List;

import javax.ejb.Remote;

import pojo.KlantGegevens;

@Remote
public interface KlantGegevensDao {
	
	List<KlantGegevens> findAll();

	List<KlantGegevens> findById();

	List<KlantGegevens> findByName();

	boolean insert(KlantGegevens klantGegevens);

	boolean update(KlantGegevens klantGegevens);

	boolean delete(KlantGegevens klantGegevens);

}
