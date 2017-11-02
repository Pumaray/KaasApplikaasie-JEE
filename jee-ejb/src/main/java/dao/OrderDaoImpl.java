package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import pojo.Order;

/**
 * Session Bean implementation class OrderDaoImpl
 */
@Stateless
@LocalBean
public class OrderDaoImpl implements OrderDao {

    /**
     * Default constructor. 
     */
    public OrderDaoImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

}
