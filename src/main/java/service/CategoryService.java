package service;

import model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CategoryService implements ICategory {
    private static String url = "jdbc:mysql://localhost:3306/product_manager";
    private static String user = "root";
    private static String password = "123456";

    public static java.sql.Connection getConnection() {
        Connection connection = null;
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
    public List<Category> getAll() {
        List<Category> lists = new ArrayList<>();
        Connection connection = getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM category");
            while (resultSet.next()) {
                Category category = new Category(resultSet);
                lists.add(category);
            }
            return lists;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Category findByID(int category) {
//        Connection connection =getConnection();
//
//        try {
//            PreparedStatement statement = connection.prepareStatement("SELECT * FROM category WHERE id = ?");
//            statement.setInt(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                Category category = new Category(resultSet);
//                return category;
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        return null;
    }
}

