package ra.academy.service;

import ra.academy.dto.ProductRequest;
import ra.academy.model.Product;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public interface IProductService extends IGenericService<Product,Integer> {
    void createProduct(ProductRequest productRequest, ServletContext servletContext);
    void updateProduct(ProductRequest productRequest, ServletContext servletContext);
}
