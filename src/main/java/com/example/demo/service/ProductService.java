package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.entity.*;
import java.util.List;

@Service
public interface ProductService {
	void addProduct(Product product);
	List<Product> getAllProducts();
	boolean isProductExist(int productId);
	Product getProductById(int productId);
	boolean deleteProduct(int productId);
	boolean updateProduct(Product product);
}