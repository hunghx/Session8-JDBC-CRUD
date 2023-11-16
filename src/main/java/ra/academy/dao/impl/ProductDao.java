package ra.academy.dao.impl;

import ra.academy.dao.IProductDao;
import ra.academy.model.Product;
import ra.academy.util.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao {
    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        Connection conn = ConnectDB.getConnection();
        try {
            PreparedStatement pre = conn.prepareStatement("Select * from product");
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getDouble("price"));
                p.setStock(rs.getInt("stock"));
                p.setImageUrl(rs.getString("image_url"));
                list.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeConnection(conn);
        }
        return list;
    }

    @Override
    public Product findById(Integer id) {
        Connection conn = ConnectDB.getConnection();
        try {
            PreparedStatement pre = conn.prepareStatement("Select * from product where id =?");
            pre.setInt(1,id);
            ResultSet rs = pre.executeQuery();
            if (rs.next()){
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getDouble("price"));
                p.setStock(rs.getInt("stock"));
                p.setImageUrl(rs.getString("image_url"));
                return p;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectDB.closeConnection(conn);
        }
        return null;
    }

    @Override
    public void save(Product product) {
        Connection conn = ConnectDB.getConnection();
        PreparedStatement pre =null;
        try{
          if(product.getId()==0){
              // thêm mới
              pre = conn.prepareCall("insert into product(name,description,price, stock, image_url)" +
                      " values(?,?,?,?,?) ");
              pre.setString(1,product.getName());
              pre.setString(2,product.getDescription());
              pre.setDouble(3,product.getPrice());
              pre.setInt(4,product.getStock());
              pre.setString(5,product.getImageUrl());

              pre.executeUpdate();

          }else {
// cap nhật
              pre = conn.prepareCall("update product set name = ?," +
                      "description=?,price=?,stock=?,image_url=? where id = ?");
              pre.setString(1,product.getName());
              pre.setString(2,product.getDescription());
              pre.setDouble(3,product.getPrice());
              pre.setInt(4,product.getStock());
              pre.setString(5,product.getImageUrl());
              pre.setInt(6,product.getId());

              pre.executeUpdate();
          }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectDB.closeConnection(conn);
        }
    }

    @Override
    public void delete(Integer id) {

    }
}
