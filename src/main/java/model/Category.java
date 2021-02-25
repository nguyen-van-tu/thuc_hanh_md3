package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Category {
    private int id;
    private String name;

    public Category(ResultSet resultSet) {
        try {
            this.id   = resultSet.getInt("id");
            this.name = resultSet.getString("name");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}