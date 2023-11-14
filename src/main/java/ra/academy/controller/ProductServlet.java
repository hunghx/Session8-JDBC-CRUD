package ra.academy.controller;

import ra.academy.dto.ProductRequest;
import ra.academy.model.Product;
import ra.academy.service.IProductService;
import ra.academy.service.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;


// cấu hình uplaod file
@WebServlet(name = "ProductServlet", value = "/ProductServlet")
@MultipartConfig(
        fileSizeThreshold = 1024*1024, // kích thước luuwu trên đía
        maxRequestSize = 25*1024*1024,
        maxFileSize = 5*1024*1024
)
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action!=null){
            switch (action){
                case "GETALL":
                    getAllProduct(productService.findAll(),request,response);
                    break;
                case "ADD":
                    request.getRequestDispatcher("/WEB-INF/views/add-product.jsp").forward(request,response);
                    break;
            }
        }
    }
    protected void getAllProduct(List<Product> list,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products",list);
        request.getRequestDispatcher("/WEB-INF/views/list-product.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if(action!=null){
            switch (action){
                case "ADD":
                    // lấy ra các thông tin bth
                    String name = request.getParameter("name");
                    String des  = request.getParameter("description");
                    double price = Double.parseDouble(request.getParameter("price"));
                    int stock = Integer.parseInt(request.getParameter("stock"));
                    Part part = request.getPart("image");
                    ProductRequest productRequest = new ProductRequest(name,des,price,stock,part);
                    productService.createProduct(productRequest,request);
                    getAllProduct(productService.findAll(),request,response);
                    break;
            }
        }
    }
}