package edu.uark.controllers;

import edu.uark.commands.products.ProductByLookupCodeQuery;
import edu.uark.commands.products.ProductQuery;
import edu.uark.commands.products.ProductSaveCommand;
import edu.uark.commands.products.ProductsQuery;
import edu.uark.models.api.Product;
import edu.uark.models.api.ProductListing;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


//All Ross did was copy the "ProductResetController"
@RestController
@RequestMapping(value = "/product")
public class EmployeeRestController {
	@RequestMapping(value = "/apiv0/{productId}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable UUID productId) {
		return (new ProductQuery()).
			setProductId(productId).
			execute();
	}

	@RequestMapping(value = "/apiv0/byLookupCode/{productLookupCode}", method = RequestMethod.GET)
	public Product getProductByLookupCode(@PathVariable String productLookupCode) {
		return (new ProductByLookupCodeQuery()).
			setLookupCode(productLookupCode).
			execute();
	}

	@RequestMapping(value = "/apiv0/products", method = RequestMethod.GET)
	public ProductListing getProducts() {
		return (new ProductsQuery()).execute();
	}
	
	@RequestMapping(value = "/apiv0/", method = RequestMethod.PUT)
	public Product putActivity(@RequestBody Product product) {
		return (new ProductSaveCommand()).
			setApiProduct(product).
			execute();
	}

	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "Things are cool";
	}
}
