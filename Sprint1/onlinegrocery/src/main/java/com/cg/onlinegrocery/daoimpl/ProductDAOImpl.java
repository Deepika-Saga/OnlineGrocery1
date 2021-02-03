package com.cg.onlinegrocery.daoimpl;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;

import com.cg.onlinegrocery.dao.ProductDAO;
import com.cg.onlinegrocery.domain.Product;
import com.cg.onlinegrocery.util.DBUtils;

public class ProductDAOImpl  implements ProductDAO {

	DBUtils dbutil;
	EntityManager entitymanager;
	public ProductDAOImpl() {
		dbutil=new DBUtils();
	}

	
	@Override
	public void addProduct(Product product) {
		entitymanager=dbutil.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.persist(product);
		entitymanager.getTransaction().commit();

	}

	@Override
	public void deleteProduct(int productId, String productName) {
		/**
		 * This removeProduct method will remove product from products table in
		 * database 
		 */
		entitymanager=dbutil.createEntityManager();
		entitymanager.getTransaction().begin();
		Product product = entitymanager.find(Product.class, productId);
		entitymanager.remove(product);
		entitymanager.getTransaction().commit();
		entitymanager.close();
	}


	@Override
	public void updateProduct(Product product1, int productId) {

		    entitymanager=dbutil.createEntityManager();
			entitymanager.getTransaction().begin();		
			Product product = entitymanager.find(Product.class, productId);
			product.setProductName(product1.getProductName());
			product.setProductAmount(product1.getProductAmount());
			product.setPrice(product1.getPrice());
			product.setDescription(product1.getDescription());
			entitymanager.getTransaction().commit();
	}

	@Override
	public Product searchProduct(String productName, int productId) {
		entitymanager=dbutil.createEntityManager();
		entitymanager.getTransaction().begin();	
		Product product = entitymanager.find(Product.class, productId);
		System.out.println("Product Id: "+ product.getProductId());
		System.out.println("Product Name: "+ product.getProductName());
		System.out.println("Product Description: "+ product.getDescription());
		System.out.println("Product Price: "+ product.getPrice());
		System.out.println("Product Amount: "+ product.getProductAmount());
		return product;
		}

	/**
	 * This findAll method will list all product details 
	 */	
	@Override
	public List<Product> findAllProducts() {
		entitymanager=dbutil.createEntityManager();
		Query query =entitymanager.createQuery("from Product");	
		
		entitymanager.getTransaction().begin();	
		List<Product> products =  query.getResultList();
		for(Product product:products)
		{
			System.out.println("Product Id: "+ product.getProductId());
			System.out.println("Product Name: "+ product.getProductName());
			System.out.println("Product Description: "+ product.getDescription());
			System.out.println("Product Price: "+ product.getPrice());
			System.out.println("Product Amount: "+ product.getProductAmount());
			System.out.println("Product Quantity: "+ product.getQuantity());
			System.out.println("-----------------------------");
	}
		
		return null;
	}


	@Override
	public void updateProductQuantity(Product product, int productId, int newProductQuantity) {
		// TODO Auto-generated method stub
		//searchProduct(null, productId);
		entitymanager=dbutil.createEntityManager();
		entitymanager.getTransaction().begin();		
		Product qtyUpdateProduct = entitymanager.find(Product.class, productId);
		int newQuantity = qtyUpdateProduct.getQuantity() + newProductQuantity;
		qtyUpdateProduct.setQuantity(newQuantity);
		entitymanager.getTransaction().commit();

	}


	@Override
	public void updateProductsQtyAfterShopping(Product orderedProduct, int productId, int orderProductQuantity) {
		// TODO Auto-generated method stub
		entitymanager=dbutil.createEntityManager();
		entitymanager.getTransaction().begin();		
		
		Product shoppingProduct = entitymanager.find(Product.class, productId);
		int newQuantity = shoppingProduct.getQuantity() - orderProductQuantity;
		shoppingProduct.setQuantity(newQuantity);
		entitymanager.getTransaction().commit();
		
	}
}



