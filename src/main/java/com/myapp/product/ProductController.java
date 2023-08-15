package com.myapp.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	ProductService prodSer;
	@PostMapping(value = "/add")
	public String addProduct(@RequestBody List<Product> p) {
		return prodSer.addProduct(p);
	}
	
	@GetMapping(value = "/find")
	public List<Product> findProducts() {
		return prodSer.findProducts();


}
}
