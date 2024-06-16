package org.example;
import java.sql.*;
public class CourseRegistrationApplication {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/baigiamasis";
        String username = "root";
        String password = "jakuliene";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Sekmingai prisijungta prie MySQL duomenu bazes!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
