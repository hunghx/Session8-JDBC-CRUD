package ra.academy.demojdbc;

import ra.academy.model.Product;
import ra.academy.util.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // mở kết nối
        Connection conn = ConnectDB.getConnection();
        List<Product> products = new ArrayList<>();
        // Statement
        // tạo câu lệnh sql
//        try {
//            Statement state = conn.createStatement();
//            ResultSet rs = state.executeQuery("select * from product ");
//            // lấy ra dữ liệu từ resultset
//            while(rs.next()){
//                Product p = new Product();
//                p.setId(rs.getInt("id"));
//                p.setName(rs.getString("name"));
//                p.setDescription(rs.getString("description"));
//                p.setPrice(rs.getDouble("price"));
//                p.setStock(rs.getInt("stock"));
//                p.setImageUrl(rs.getString("image_url"));
//                products.add(p);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }finally {
//            ConnectDB.closeConnection(conn);
//        }
//        System.out.println(products);

        // thêm mới
//        try {
//            conn = ConnectDB.getConnection();
//            Statement state = conn.createStatement();
//           int count = state.executeUpdate("INSERT INTO PRODUCT(name,description,price,stock,image_url)" +
//                   " values('Áo ba lỗ','no mô tả',999999,99,'https://i.pinimg.com/736x/e8/97/72/e897728aef0930bfeba1461bbb00798b.jpg')");
//            System.out.println("số bản ghi thây đổi "+count);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }finally {
//            ConnectDB.closeConnection(conn);
//        }

        // PrepareStatement
//        Product p =null;
//        System.out.println("Hãy nhập id muốn tìm kiếm");
//        int id = new Scanner(System.in).nextInt();
//        try {
//            PreparedStatement pre = conn.prepareStatement("select * from product where id = ?");
//            // truyền giá trị cho tham số
//            pre.setInt(1,id);
//            ResultSet rs = pre.executeQuery();
////             lấy ra dữ liệu từ resultset
//            if(rs.next()){
//                 p = new Product();
//                p.setId(rs.getInt("id"));
//                p.setName(rs.getString("name"));
//                p.setDescription(rs.getString("description"));
//                p.setPrice(rs.getDouble("price"));
//                p.setStock(rs.getInt("stock"));
//                p.setImageUrl(rs.getString("image_url"));
//                products.add(p);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(p);

        // cập nhật product
        // CallableStatement
//        try {
//            CallableStatement call = conn.prepareCall("{call proc_update_product(?,?,?,?,?,?)}");
//            // truyền ccacs tham số vào
//            call.setInt(1,3);
//            call.setString(2,"Quần đùi nam");
//            call.setString(3,"quần thoáng mát mùa hè");
//            call.setDouble(4,555000);
//            call.setInt(5,99);
//            call.setString(6,"https://tse3.mm.bing.net/th?id=OIP.JQxQ5BicPLRlhbB4dY2xmgHaJO&pid=Api&P=0&h=220");
//            boolean check = call.execute();
//            System.out.println(check);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

//        try {
//            CallableStatement call = conn.prepareCall("{call calculator_product(?,?)}");
//            call.registerOutParameter(1,Types.DOUBLE);
//            call.registerOutParameter(2,Types.INTEGER);
//            call.execute();
//            double avg = call.getDouble(1);
//            int total = call.getInt(2);
//            System.out.println("Giá trung bình :"+avg);
//            System.out.println("Tổng số lượng trong kho :"+total);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

    }
}
