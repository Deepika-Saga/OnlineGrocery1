package com.cg.onlinegrocery.service;

import java.util.List;
import com.cg.onlinegrocery.domain.Delivery;

public interface ProductDeliveryService {
	public Delivery Orderstatus();
	public Delivery description();
	public List<ProductDeliveryService> getProductDeliveryService();
	String description1();
		
	}

     enum Orderastatus {
	Received,Assigned,Delivered, Orderstatus;
	public static void main(String args[]) {
		Orderastatus a = Orderstatus.Received;
		System.out.println(a);
	}
}