package service;

import model.Product;
import model.ProductView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProduct {
    private static String url = "jdbc:mysql://localhost:3306/product_manager";
    private static String user = "root";
    private static String password = "123456";

    public static java.sql.Connection getConnection() {
        java.sql.Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,
                    user,
                    password
            );
        } catch (ClassNotFoundException e) {
            System.out.println("không có driver");
        } catch (SQLException throwables) {
            System.out.println("Không kết nối được");
        }
        System.out.println("ket noi thanh cong");

        return connection;
    }

    @Override
    public List findAll() {
        List<ProductView> products = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select lp.id, lp.name as product_name, lp.price," +
                    " lp.quantity, lp.color, lp.description, c.name as category_name from list_product" +
                    " as lp join category c on c.id = lp.category_id;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("product_name");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String category_name = resultSet.getString("category_name");

                ProductView productView = new ProductView(id, name, price, quantity, color, description, category_name);
                products.add(productView);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }


    @Override
    public boolean edit(Product product) {
        boolean check = false;
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement("update list_product set name= ?, price =?, quantity = ?, color =? , description =? ,category_id = ? where id = ?");
            preparedStatement.setInt(7, product.getId());
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, (int) product.getPrice());
            preparedStatement.setString(3, String.valueOf(product.getQuantity()));
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6,product.getCategoryID());
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }


    @Override
    public Product findById(int id) {
        Product product = null;
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id =?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                int category_id = rs.getInt("category_id");
                product = new Product(id, name, price, quantity, color, description, category_id);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return product;
    }

    @Override
    public void delete(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from list_product where id = ?;");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Product create(Product product) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into list_product(name, price, quantity, color, description, category_id) value (?,?,?,?,?,?) ;");

            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, (int) product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getCategoryID());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return product;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement("select * from list_product where name like ?");
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name1 = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                String color=resultSet.getString("color");
                String description = resultSet.getString("description");
                int categoryId=resultSet.getInt("categoryId");
                products.add(new Product(name1, price,quantity,color, description,categoryId));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }
    }


