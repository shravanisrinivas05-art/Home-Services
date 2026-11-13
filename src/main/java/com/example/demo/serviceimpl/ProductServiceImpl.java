package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public void addProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> productList = productRepository.findAll();
		return productList;
	}

	
	@Override
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		Optional<Product> product = productRepository.findById(productId);
		Product prod;
		if(product.isPresent()) {
			prod = product.get();
		}else {
			throw new ResourceNotFoundException("Product", "ProductId",productId);
		}
		
		return prod;
	}

	@Override
	public boolean deleteProduct(int productId) {
		Optional<Product> product = productRepository.findById(productId);
		
		if(product.isPresent()) {
			productRepository.deleteById(productId);
			return true;
		}else {
			return  false;
		}
	
	}

	@Override
	public boolean updateProduct(Product product) {
		Optional<Product> product1 = productRepository.findById(product.getProductId());
		Product prod;
		if(product1.isPresent()) {
			productRepository.save(product);
			return true;
		}else {
			return false;
			
		}
		
	}

	@Override
	public boolean isProductExist(int productId) {
		Optional<Product> product = productRepository.findById(productId);
		Product prod;
		if(product.isPresent()) {
			return true;
		}else {
			return false;
			
		}
	}

}