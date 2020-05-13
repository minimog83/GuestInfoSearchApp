/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

/**
 *
 * @author Tran Trong Hoai
 */
import  java.util.ArrayList;

import model.Customer;
import model.OrderControlUtility;
import dao.CustomerSearchDBAccess;

public class CustomerSearchAction {
    public String[][] execute(String[] data) throws Exception {
        CustomerSearchDBAccess csDao = new CustomerSearchDBAccess();
        ArrayList<Customer> list = null;
        String[][] tableData = null;
        
        if (!data[0].equals("")) {
            list = csDao.searchCustomerByTel(data[0]);
        } else {
            data[1] = data[1].replaceAll(" ","");
            data[1] = data[1].replaceAll("  ","");
            if (!data[1].equals("")) {
                list = csDao.searchCustomerByKana(data[1]);
            }
        }
        
        if  (list != null && list.size() != 0) {
            tableData = OrderControlUtility.customerToArray(list);
        }
        return tableData;
    }
}
