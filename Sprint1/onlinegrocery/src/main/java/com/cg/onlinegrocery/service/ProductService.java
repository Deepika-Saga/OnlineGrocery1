package com.cg.onlinegrocery.service;

import java.util.List;
import com.cg.onlinegrocery.domain.Product;

public interface ProductService {
	public void addProduct(Product product);
	public void deleteProduct(int productId, String productName);
	public Product searchProduct(String productName, int productId);
	public void updateProduct(Product product1, int productId);
	public void updateProductQuantity(Product product, int productId, int productQuantity);
	public void updateProductsQtyAfterShopping(Product orderedProduct,int productId, int orderProductQuantity);
	public List<Product> viewAllProducts(Product products);
	

}
