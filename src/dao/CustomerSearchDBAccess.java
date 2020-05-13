/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Customer;

/**
 *
 * @author Tran Trong Hoai
 */
public class CustomerSearchDBAccess {
    
    private Connection createConnection() throws Exception {
        Connection con = null;
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/KIDDA_LA?useSSL=false&characterEncoding=UTF-8" ,
                    "user1",
                    "pass1");
        } catch (ClassNotFoundException e) {
                throw new Exception("DB接続処理に失敗しました");
            } catch(SQLException e) {
                throw new Exception("DB接続処理に失敗しました");
            }
        return con;
}
    private void closeConnection(Connection con) throws Exception {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            throw new Exception("DB接続処理に失敗しました");
        }
    }
public ArrayList<Customer> searchCustomerByTel(String tel) throws Exception {
    Connection con = createConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList<Customer> list = new ArrayList<Customer>();
    
    try {
        pstmt = con.prepareStatement("SELECT CUSTID, CUSTNAME, KANA, ADDRESS FROM CUSTOMER WHERE TEL =?");
        pstmt.setString(1,tel);
        rs = pstmt.executeQuery();
        
        while(rs.next()) {
            int custId = rs.getInt("CUSTID");
            String custName = rs.getString("CUSTNAME");
            String kana = rs.getString("KANA");
            String address = rs.getString("ADDRESS");
            Customer customer = new Customer(custId, custName, kana, tel, address);
            list.add(customer);
        }
    } catch (SQLException e) {
        throw new Exception("顧客情報検索処理に失敗しました");
    } finally {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    closeConnection(con);
    return list;
    }
public ArrayList<Customer> searchCustomerByKana(String kana) throws Exception {
    Connection con = createConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList<Customer> list = new ArrayList<Customer>();
    
    try {
        pstmt = con.prepareStatement("SELECT CUSTID, CUSTNAME, TEL, ADDRESS FROM CUSTOMER WHERE KANA LIKE ?");
        pstmt.setString(1,"%" + kana + "%");
        rs = pstmt.executeQuery();
        
        while(rs.next()) {
            int custId = rs.getInt("CUSTID");
            String custName = rs.getString("CUSTNAME");
            String custKana = rs.getString("KANA");
            String tel = rs.getString("TEL");
            String address = rs.getString("ADDRESS");
            Customer customer = new Customer(custId, custName, custKana, tel, address);
            list.add(customer);
        }
    } catch (SQLException e) {
        throw new Exception("顧客情報検索処理に失敗しました");
    } finally {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    closeConnection(con);
    return list;
    }
}
