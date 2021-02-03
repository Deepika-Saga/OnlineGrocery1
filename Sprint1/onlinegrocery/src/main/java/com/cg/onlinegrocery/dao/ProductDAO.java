package com.cg.onlinegrocery.dao;

import java.util.List;

import com.cg.onlinegrocery.domain.Product;

/**
 * This ProductDAO interface will perform CRUD Operations on Product
 *
 */

public interface ProductDAO {
	
	/**
	 * This addProduct method will save the product object in products table
	 * @param product object to be saved
	 */
	void addProduct(Product product);
	
	/**		
	 * This removeProduct method will delete the  product object from products table
	 * @param product to be deleted
	 */
	void deleteProduct(int productId, String productName);
	/**
	 * This delete method will delete the product based on id from products table
	 * @param id of the product to be deleted
	 */
	 
	void updateProduct(Product product1, int productId);
	/**
	 * This findAll method will return the list of users if found 
	 * @return list of products if found otherwise null
	 */
	
	Product searchProduct(String productName, int productId);
	/**
	 * This findAll method will return the list of users if found 
	 * @return list of products if found otherwise null
	 */
    
	
	/**		
	 * This updateProductQuantity method will update the existing product quantity in products table
	 * @param product to be updated
	 * @param productId 
	 */
	void updateProductQuantity(Product product, int productId, int productQuantity);
	
	
	/**		
 	 * This updateProductsQtyAfterShopping method will update the  products quantity after shopping in products table
 	 * @param products quantity to be updated
 	 */
     void updateProductsQtyAfterShopping(Product orderedProduct,int productId, int orderProductQuantity);
 	
 	
 	
	List<Product> findAllProducts();
	

}
	


