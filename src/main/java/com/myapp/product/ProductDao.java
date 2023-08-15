package com.myapp.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class ProductDao {
	
	@Autowired
	ProductRepository prodRepo;

	public String addProduct(List<Product> p) {

		prodRepo.saveAll(p);
		return "successfully added";
	}
	public List<Product> findProducts() {
		return prodRepo.findAll();

}
}
