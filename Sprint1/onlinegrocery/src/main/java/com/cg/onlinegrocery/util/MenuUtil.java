package com.cg.onlinegrocery.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.cg.onlinegrocery.dao.OrderDAO;
import com.cg.onlinegrocery.dao.ProductDAO;
import com.cg.onlinegrocery.daoimpl.ProductDAOImpl;
import com.cg.onlinegrocery.domain.OrderDetail;
import com.cg.onlinegrocery.domain.Product;

public class MenuUtil {
	private ProductDAO productDAO;
	private OrderDAO orderDAO;
	int choice;
	String role;
	String continueChoice;
	Scanner sc = new Scanner(System.in);
	public MenuUtil() {
		productDAO = new ProductDAOImpl();
//		orderDAO = new OrderDAOImpl();
	}

	public void start() {
//		Scanner sc = new Scanner(System.in);
//		int choice;
//		String role;
//		String continueChoice;

		do {
			productManagement();
//			System.out.println("Enter Your Choice");
//			choice = sc.nextInt();
//			System.out.println("Enter Your UserRole");
//			role =sc.next();
//			System.out.println("Role:"+role);
//			choiceManagement();
			//choice= validateChoice(choice,role);
//			if(choice==1 || choice==2) {
//				if(!role.isBlank() && !role.equals("Admin")) {
//					System.out.println("Admin role is required to Add or Delete product");
//					choice=0;
//					System.out.println("Do you want to continue : [yes/no]");
//					continueChoice = sc.next();
//					productManagement();
//					choiceManagement();
//				}
//			}
			if(choice==6) {
				if(!role.isBlank()) {
//					System.out.println("Role:::"+role);
					if (!(role.equals("Admin") || role.equals("StoreIncharge"))){
						System.out.println("Only Admin or Store Incharge can update the Product Quantity");
						choice=0;
						choiceManagement();
					}else {
						choice = 6 ;
					}
				}
					
			}

			switch (choice) {
			
			
			case 1:

			{
				
				Product product = new Product();
				System.out.println("Enter Product Name");
				product.setProductName(sc.next());
				System.out.println("Enter Product Description ");
				product.setDescription(sc.next());
				System.out.println("Enter Product Price ");
				product.setPrice(sc.nextDouble());
				System.out.println("Enter Product Amount");
				product.setProductAmount(sc.nextInt());
				System.out.println("Enter Product Quantity");
				product.setQuantity(sc.nextInt());

				productDAO.addProduct(product);
				System.out.println("--------------------Product Successfully Added--------------------------");
			//}else {
			//	System.out.println("Please provide correct Role");
			//}
		}

				break;

			case 2:
				System.out.println("Enter Product ID");
				int productID = sc.nextInt();
				System.out.println("Enter Product Name");
				String productName = sc.next();
				productDAO.deleteProduct(productID,productName);
				System.out.println("---------------Product Successfully Removed-------------------");

				break;
				
			case 3:
				System.out.println("Enter Product Name");
				String prodName = sc.next();
				System.out.println("Enter Product ID");
				int prodID = sc.nextInt();
				
				productDAO.searchProduct(prodName,prodID);

				System.out.println("---------------Product Found------------------");
				
				break;

			case 4:
				
				Product product1 = new Product();
				System.out.println("Enter product id to be updated");
				int pID = sc.nextInt();
				System.out.println("Enter Updated Product Name");
				product1.setProductName(sc.next());
				System.out.println("Enter Updated Product Description ");
				product1.setDescription(sc.next());
				System.out.println("Enter Updated Product Price ");
				product1.setPrice(sc.nextDouble());
				System.out.println("Enter Updated Product Amount");
				product1.setProductAmount(sc.nextInt());
				System.out.println("Enter Updated Product Quantity");
				product1.setQuantity(sc.nextInt());
				productDAO.updateProduct(product1,pID);
				System.out.println("---------------Product Updated------------------");
				System.out.println("Product Id: "+ product1.getProductId());
				System.out.println("Product Name: "+product1.getProductName());
				System.out.println("Product Description: "+ product1.getDescription());
				System.out.println("Product Price: "+ product1.getPrice());
				System.out.println("Product Amount: "+ product1.getProductAmount());
				System.out.println("Product Quantity: "+ product1.getQuantity());

				break;
				
			case 5:
				System.out.println("---------------List of All Products------------------");
				productDAO.findAllProducts();
				
				break;
				
			case 6:
				
				Product qtyUpdateProduct ;
				
				
				System.out.println("Enter Product Name");
				String pName = sc.next();
				System.out.println("Enter Product ID");
				int productId = sc.nextInt();
				
				qtyUpdateProduct = productDAO.searchProduct(pName,productId);

				System.out.println("---------------Product Found------------------");
				System.out.println("Existing Product Quantity: "+ qtyUpdateProduct.getQuantity());
				
				System.out.println("Enter Product Quantity to Add:");
				int newProductQuantity = sc.nextInt();
				
				
				System.out.println("Enter Updated Product Quantity");
				//qtyUpdateProduct.setQuantity(newProductQuantity);
				productDAO.updateProductQuantity(qtyUpdateProduct,productId, newProductQuantity);
				System.out.println("---------------Product Updated------------------");
				//System.out.println("Updated Product Quantity: "+ qtyUpdateProduct.getQuantity());

				break;
			
			case 7:
				
				OrderDetail order = new OrderDetail();
				Product p1 = new Product();
				Product p2 = new Product();
				List<Product> products = new ArrayList<Product>();
				p1.setProductId(1);
				p1.setProductName("Soaps");
				p1.setQuantity(5);
				
				p2.setProductId(2);
				p1.setProductName("Biscuit");
				p2.setQuantity(10);
				
				order.setId("123");
				products.add(p1);
				products.add(p2);
				order.setProduct(p1);
				//order.setProducts(products);
				
				Product qtyUpdateShoppingProduct = null;
				System.out.println("Enter the OrderID");
				String orderID = sc.next();
				
//				List<Product> orderProducts = (List<Product>) order.getProducts();
//				for (Iterator iterator = orderProducts.iterator(); iterator.hasNext();) {
//					Product shoppingProduct = (Product) iterator.next();
//					int shoppingProductId = shoppingProduct.getProductId();
//					int orderedProductQuantity = shoppingProduct.getQuantity();
//					String orderedProductName = shoppingProduct.getProductName();
//					qtyUpdateShoppingProduct = productDAO.searchProduct(orderedProductName,shoppingProductId);
//					System.out.println("---------------Product Found------------------");
//					
//					System.out.println("Existing Product Quantity: "+ qtyUpdateShoppingProduct.getQuantity());
//					
//					productDAO.updateProductsQtyAfterShopping(qtyUpdateShoppingProduct,shoppingProductId, orderedProductQuantity);
//					System.out.println("---------------Product Quantity Updated------------------");
//				}
				
				
				Product shoppingProduct =  order.getProduct();
					
				int shoppingProductId = shoppingProduct.getProductId();
					int orderedProductQuantity = shoppingProduct.getQuantity();
					String orderedProductName = shoppingProduct.getProductName();
					qtyUpdateShoppingProduct = productDAO.searchProduct(orderedProductName,shoppingProductId);
					System.out.println("---------------Product Found------------------");
					
					System.out.println("Existing Product Quantity: "+ qtyUpdateShoppingProduct.getQuantity());
					
					productDAO.updateProductsQtyAfterShopping(qtyUpdateShoppingProduct,shoppingProductId, orderedProductQuantity);
					System.out.println("---------------Product Quantity Updated for ordered product------------------");
				

				break;

			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("Wrong Choice");
				break;
			}
			System.out.println("Do you want to continue : [yes/no]");
			continueChoice = sc.next();
		} while (continueChoice.equalsIgnoreCase("yes"));
		sc.close();
	}

	private int validateChoice(int choice1, String role1) {
		// TODO Auto-generated method stub
		int returnChoice=0;
			if(!role1.isBlank() && !role1.equals("Admin")) {
				System.out.println("Admin role is required to Add or Delete product");
				System.exit(0);
				System.out.println("Do you want to continue : [yes/no]");
				continueChoice = sc.next();
				productManagement();
			}else {
				returnChoice=choice1;
			}
		return returnChoice;
	}

	public void productManagement() {
		System.out.println("--------GROCERY SHOP---------");
		System.out.println("1.ADD PRODUCT");
		System.out.println("2.REMOVE PRODUCT");
		System.out.println("3.SEARCH PRODUCT");
		System.out.println("4.UPDATE PRODUCT");
		System.out.println("5.SHOW ALL PRODUCTS");
		System.out.println("6.UPDATE PRODUCT QUANTITY");
		System.out.println("7.UPDATE PRODUCTS QUANTITY AFTER SHOPPING");
		System.out.println("0.EXIT");
		System.out.println();
		choiceManagement();
	}
	
	public void choiceManagement() {
		
		System.out.println("Enter Your Choice");
		choice = sc.nextInt();
		if(choice==1 || choice==2 || choice==6) {
			System.out.println("Enter Your UserRole");
			role =sc.next();
			if (choice!=6) {
				choice= validateChoice(choice, role);
			}
			//System.out.println("Role:"+role);
		}
		
	}

}