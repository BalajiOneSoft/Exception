package com.myapp.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
	
	@Autowired
	ProductDao  prodDao;

	public String addProduct(List<Product> p) {

		return prodDao.addProduct(p);
	}
	public List<Product> findProducts() {
		return prodDao.findProducts();

	}
}
