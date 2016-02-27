package report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.Product;
import model.ProductModel;

public class ProductReport {

	public List<Map<String, ?>> findAll() {
		List<Map<String, ?>> listProducts = new ArrayList<Map<String, ?>>();
		ProductModel productModel = new ProductModel();
		for (Product p : productModel.findAll()) {
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("id", p.getId());
			m.put("name", p.getName());
			m.put("price", p.getPrice());
			m.put("quartity",p.getQuarity());
			
			listProducts.add(m);
		}
		return listProducts;
	}
}