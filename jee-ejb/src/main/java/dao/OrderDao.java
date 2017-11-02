package dao;

import java.util.List;

import javax.ejb.Remote;

import pojo.Order;

@Remote
public interface OrderDao {

	List<Order> findAll();

	List<Order> findById();

	List<Order> findByName();

	boolean insert(Order order);

	boolean update(Order order);

	boolean delete(Order order);

}
