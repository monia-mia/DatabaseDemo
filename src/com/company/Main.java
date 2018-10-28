package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
	// write your code here
        Class.forName("org.h2.Driver");

        try (Connection con =  DriverManager.getConnection("jdbc:h2:mem:com.company"); //łączy sie z bazą danych, ten url pozwala na bazę danych tylko w pamięci ram komptera
        ){
            Statement s = con.createStatement();
            s.execute("CREATE TABLE Test(ID INTEGER PRIMARY KEY, Text VARCHAR)");
            System.out.println(s.executeUpdate("INSERT INTO Test(ID, Text) VALUES (1, 'Test1')"));

            s.executeUpdate("INSERT INTO Test(ID, Text) VALUES (2, 'Test2')");
            s.executeUpdate("INSERT INTO Test(ID, Text) VALUES (3, 'Test3')");
            s.executeUpdate("INSERT INTO Test(ID, Text) VALUES (4, 'Test4')");

            ResultSet rs = s.executeQuery("SELECT * FROM Test");
            System.out.println(rs);

            while(rs.next()) {
                System.out.println("ID: "+rs.getInt(1));
                System.out.println("Text: " +rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
