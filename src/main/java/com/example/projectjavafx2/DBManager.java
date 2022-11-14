package com.example.projectjavafx2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    public List<Clothes> loadClothes(){
        List<Clothes> clothesAll= new ArrayList<Clothes>();
        Connection myConn= this.Connector();
        try {
            Statement myStmt= myConn.createStatement();
            String sql = "select * from clothes";
            ResultSet myRs= myStmt.executeQuery(sql);
            while (myRs.next()) {
                Clothes c= new Clothes(myRs.getString("name"),
                        myRs.getDouble("price"), myRs.getInt("nbItems"),
                        myRs.getInt("size"));

                clothesAll.add(c);
            }
            this.close(myConn, myStmt, myRs);
            return clothesAll;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Connection Connector(){
        try {
            Connection connection =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?serverTimezone=Europe%2FParis", "root","root");
            return connection;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
        try{
            if(myStmt!=null)
                myStmt.close();
            if(myRs!=null)
                myRs.close();
            if(myConn!=null)
                myConn.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
