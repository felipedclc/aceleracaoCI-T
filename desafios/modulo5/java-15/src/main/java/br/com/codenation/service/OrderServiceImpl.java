package br.com.codenation.service;

import java.util.*;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

	private ProductRepository productRepository = new ProductRepositoryImpl();

	/**
	 * Calculate the sum of all OrderItems
	 */
	@Override
	public Double calculateOrderValue(List<OrderItem> items) {
		return items.stream().map(orderItem -> {
			Product product = productRepository.findById(orderItem.getProductId()).get();
			Double price = product.getIsSale() ? product.getValue() * 0.80 : product.getValue();
			return price * orderItem.getQuantity();
		}).mapToDouble(value -> value).sum();

	}

	/**
	 * Map from idProduct List to Product Set
	 */
	@Override
	public Set<Product> findProductsById(List<Long> ids) {
		Set<Product> products = new HashSet<>();
		ids.forEach(id -> products.add(productRepository.findById(id).get()));
		return products;
	}

	/**
	 * Calculate the sum of all Orders(List<OrderIten>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		return orders.stream().map(orderItems -> calculateOrderValue(orderItems))
				.mapToDouble(items -> items).sum();
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
		Map<Boolean, List<Product>> productsMap = new HashMap<>();
		List<Product> productsIsSale = new ArrayList<>();
		List<Product> productsIsNotSale = new ArrayList<>();

		productIds.forEach(id -> {
			Product product = productRepository.findById(id).get();
			if (product.getIsSale()) productsIsSale.add(product);
			else productsIsNotSale.add(product);
		});

		productsMap.put(true, productsIsSale);
		productsMap.put(false, productsIsNotSale);
		return productsMap;
	}

}