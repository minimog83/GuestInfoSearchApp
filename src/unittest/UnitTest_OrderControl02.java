package unittest;

import java.util.ArrayList;
import dao.CustomerSearchDBAccess;
import model.Customer;

// 単体番号２　ドライバクラス（CustomerSearchDBAccessクラス）
public class UnitTest_OrderControl02 {

    public static void main(String[] args) {
        CustomerSearchDBAccess dao = new CustomerSearchDBAccess();
        
        try {
            // 項番１
            System.out.println("--項番１----------------------------------");
            ArrayList<Customer> list1 = dao.searchCustomerByTel("08012345678");
            System.out.println(list1.size());
            System.out.println(list1.get(0).getCustId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            // 項番２
            System.out.println("--項番２----------------------------------");
            ArrayList<Customer> list2 = dao.searchCustomerByTel("0120345678");
            System.out.println(list2.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            // 項番３
            System.out.println("--項番３----------------------------------");
            ArrayList<Customer> list3 = dao.searchCustomerByTel("");
            System.out.println(list3.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            // 項番４
            System.out.println("--項番４----------------------------------");
            ArrayList<Customer> list4 = dao.searchCustomerByTel(null);
            System.out.println(list4.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            // 項番５
            System.out.println("--項番５----------------------------------");
            dao.searchCustomerByTel("08012345678");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            // 項番６
            System.out.println("--項番６----------------------------------");
            ArrayList<Customer> list6 = dao.searchCustomerByKana("シバタリュウイチ");
            System.out.println(list6.size());
            System.out.println(list6.get(0).getCustId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            // 項番７
            System.out.println("--項番７----------------------------------");
            ArrayList<Customer> list7 = dao.searchCustomerByKana("スズキ");
            System.out.println(list7.size());
            for (Customer customer : list7) {
                System.out.print(customer.getCustId() + "\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            // 項番８
            System.out.println("--項番８----------------------------------");
            ArrayList<Customer> list8 = dao.searchCustomerByKana("キタジマコウスケ");
            System.out.println(list8.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            // 項番９
            System.out.println("--項番９----------------------------------");
            ArrayList<Customer> list9 = dao.searchCustomerByKana("");
            System.out.println(list9.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            // 項番10
            System.out.println("--項番10----------------------------------");
            ArrayList<Customer> list10 = dao.searchCustomerByKana(null);
            System.out.println(list10.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            // 項番11
            System.out.println("--項番11----------------------------------");
            dao.searchCustomerByKana("シバタリュウイチ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
