package ra.academy.service.impl;

import ra.academy.dao.IProductDao;
import ra.academy.dao.impl.ProductDao;
import ra.academy.dto.ProductRequest;
import ra.academy.model.Product;
import ra.academy.service.IProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ProductService implements IProductService {
    private IProductDao productDao = new ProductDao();
    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return null;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void createProduct(ProductRequest productRequest, HttpServletRequest request) {
        String uploadPath ="C:\\Users\\hung1\\OneDrive\\Desktop\\JDBC-Connect-Mysql\\src\\main\\webapp\\uploads";
        File file = new File(uploadPath);
        if (!file.exists()){
            file.mkdirs();
        }
         // xử lí upload file
        Part part = productRequest.getImage();
        String filename = part.getSubmittedFileName();// lấy ra tên file upload
        try {
            part.write(uploadPath+File.separator+filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Product p = new Product(productRequest.getStock(),productRequest.getName(),productRequest.getDescription(),filename,productRequest.getPrice());
        productDao.save(p);
    }
}
