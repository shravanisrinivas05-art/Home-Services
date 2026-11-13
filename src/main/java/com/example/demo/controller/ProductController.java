package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping(value = "/addProduct")
	public ResponseEntity<Object> addProduct(@RequestBody Product product){
		productService.addProduct(product);
		return new ResponseEntity<>("Product added succesfully",HttpStatus.CREATED);
		
	}
	@GetMapping(value = "/allProducts")
	public ResponseEntity<Object> getAllProducts() {
		List<Product> products = productService.getAllProducts();
		ResponseEntity<Object> entity = new ResponseEntity<>(products, HttpStatus.OK);
		return entity;
	}
	//get product though path variable
		@GetMapping(value = "/getProduct/{productId}")
		public ResponseEntity<Object> getProduct(@PathVariable("productId") int productId) {
			Product product;

			if (productService.isProductExist(productId)) {
				product = productService.getProductById(productId);
			} else {
				product = null;
			}
			ResponseEntity<Object> entity = new ResponseEntity<>(product, HttpStatus.OK);
			return entity;
		}
		//get product though request parameter variable
		@GetMapping(value = "/getProduct1")
		public ResponseEntity<Object> getProduct1(@RequestParam("productId") int productId) {
			Product product;

			if (productService.isProductExist(productId)) {
				product = productService.getProductById(productId);
			} else {
				product = null;
			}
			ResponseEntity<Object> entity = new ResponseEntity<>(product, HttpStatus.OK);
			return entity;
		}
		@PutMapping(value = "/updateProduct/{productId}")
		public ResponseEntity<Object> updateProduct(@PathVariable("productId") int productId,
				@RequestBody Product product) {
			
			boolean flag;
			if (productService.isProductExist(productId)) {
				flag = productService.updateProduct(product);
			} else {
				flag = false;
			}

			return new ResponseEntity<>(flag, HttpStatus.OK);
		}
		@DeleteMapping(value = "/deleteProduct/{productId}")
		public ResponseEntity<Object> deleteProduct(@PathVariable("productId") int productId) {

			boolean flag;
			if (productService.isProductExist(productId)) {
				flag = productService.deleteProduct(productId);
			} else {
				flag = false;
			}

			return new ResponseEntity<>(flag, HttpStatus.OK);
		}

}
