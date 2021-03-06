package org.sharding.jdbc.demo.realize.yaml.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.sharding.jdbc.demo.realize.dao.DBHandlerDao;
import org.sharding.jdbc.demo.realize.entity.Order;
import org.sharding.jdbc.demo.realize.entity.OrderItem;
import org.sharding.jdbc.demo.realize.yaml.dao.impl.DBHandlerDaoImpl;

/**
 * 测试Sharding-jdbc的分库分表能力
 * @author liuyazhuang
 *
 */
public class ShardingDBTest {
	private DBHandlerDao handlerDao;
	
	@Before
	public void init() throws Exception{
		handlerDao = new DBHandlerDaoImpl();
	}
	
	@Test
	public void testSaveOrder() throws Exception{
		Order order = new Order(4, 2);
		System.out.println(handlerDao.saveOrder(order));
		
	}
	@Test
	public void testGetOrder() throws Exception{
		System.out.println(handlerDao.getOrder(4));
	}
	@Test
	public void testGetOrderList() throws Exception{
		List<Order> orderList = handlerDao.getOrderList();
		for(Order order : orderList) {
			System.out.println(order.toString());
		}
	}
	@Test
	public void testSaveOrderItem() throws Exception{
		OrderItem item = new OrderItem(3, 3, 2);
		System.out.println(handlerDao.saveOrderItem(item));
	}
	@Test
	public void testGetOrderItem() throws Exception{
		System.out.println(handlerDao.getOrderItem(3));
	}
	@Test
	public void testGetOrderItemList() throws Exception{
		List<OrderItem> orderItemList = handlerDao.getOrderItemList();
		for(OrderItem item : orderItemList) {
			System.out.println(item.toString());
		}
	}
}
