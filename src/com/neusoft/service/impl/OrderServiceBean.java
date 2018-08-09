package com.neusoft.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.mapper.CouponMapper;
import com.neusoft.mapper.CustomerMapper;
import com.neusoft.mapper.OrderMapper;
import com.neusoft.mapper.RefundMapper;
import com.neusoft.po.Coupon;
import com.neusoft.po.Customer;
import com.neusoft.po.Order;
import com.neusoft.po.Refund;
import com.neusoft.service.OrderService;
import com.neusoft.tools.Page;

@Service
public class OrderServiceBean implements OrderService {

	@Autowired
	private OrderMapper mapper;
	@Autowired
	private CustomerMapper customermapper;
	@Autowired
	private RefundMapper refundmapper;
	@Autowired
	private CouponMapper couponMapper;
	
	@Override
	public List<Order> findAllOrder(Page page) throws Exception {
		return mapper.findAllOrder(page);
	}

	@Override
	public List<Order> findOrder(Map map) throws Exception {
		return mapper.findOrder(map);
	}

	@Override
	public boolean updateOrder(Order order) throws Exception {
		boolean isok=false;
		//System.out.println("status="+order.getStatus());
		if(order.getStatus().equals("�Ѹ���")){  //���� ��Ǯ
			//System.out.println("test");
			Customer customer=new Customer();
			customer.setMoney(0-order.getTotal());
			customer.setPhone(order.getOpenid());
			if(customermapper.updateCustomer(customer)<=0) return false;
			order.setActual(order.getTotal());
		}
		if(order.getStatus().equals("�˿���")){  //��rufund�в����¼
			Refund r=refundmapper.findRefundByOid(order.getOid());
			if(r==null){
				Refund r1=new Refund();
				r1.setOid(order.getOid());
				r1.setStatus("������");
				Date date=new Date();
				SimpleDateFormat ft =new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
				r1.setRefundtime(ft.format(date));
				if(refundmapper.saveRefund(r1)<=0) return false;
			}else{
				r.setStatus("������");
				Date date=new Date();
				SimpleDateFormat ft =new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
				r.setRefundtime(ft.format(date));
				if(refundmapper.updateRefundByOid(r)<=0) return false;
			}
		}
		int result=mapper.updateOrder(order);
		if(result>0){
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public List<Order> findAllOrderByPhone(String phone) throws Exception {
		return mapper.findAllOrderByPhone(phone);
	}

	@Override
	public boolean saveOrder(Order order) throws Exception {
		boolean isok=false;
		if(order.getStatus().equals("�Ѹ���")){  //���� ��Ǯ
			Customer customer=new Customer();
			customer.setMoney(0-order.getTotal());
			customer.setPhone(order.getOpenid());
			if(customermapper.updateCustomer(customer)<=0) return false;
			order.setActual(order.getTotal());
		}
		int result=mapper.saveOrder(order);
		if(result>0){
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}
	
	@Override
	public int findCount(int qid) throws Exception {
		return mapper.findCount(qid);
	}

	@Override
	public int findCountByCondition(Map map) throws Exception {
		return mapper.findCountByCondition(map);
	}

	@Override
	public List<Order> findOrderByPhone(String phone) throws Exception {
		return mapper.findOrderByPhone(phone);
	}

	@Override
	public Order findOrderByOid(int oid) throws Exception {
		return mapper.findOrderByOid(oid);
	}

	@Override
	public boolean saveOrder2(Order order, int couponid) throws Exception {   //�Ż�ȯ����
		boolean isok=false;
		Coupon c=couponMapper.findCouponById(couponid);
		if(c==null) return false;
		order.setActual(order.getTotal()*c.getDiscount());
		if(mapper.saveOrder(order)<=0) return false;
		if(couponMapper.updateCoupon(c)<=0) return false;
		isok=true;
		return isok;
	}
}
