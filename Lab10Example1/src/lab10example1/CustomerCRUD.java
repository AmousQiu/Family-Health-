package lab10example1;

import java.sql.*;

/**
 *
 * @author syedmfaizan
 */
public class CustomerCRUD {
    private MysqlDatabaseConnection connection=null;
    
    CustomerCRUD(MysqlDatabaseConnection conn){
        this.connection=conn;
    }
    
    ResultSet getAllCustomers(){
        return connection.executeQuery("SELECT * FROM CUSTOMER");
    }
    
    ResultSet getCustomerByCode(String Code){
        return connection.executeQuery("SELECT * FROM CUSTOMER Where CUS_CODE="+Code);
    }
    
    ResultSet getCustomerProducts(String Code){
        return connection.executeQuery( "SELECT  PRODUCT.p_code, PRODUCT.p_descript, PRODUCT.p_price\n" +
                                        "FROM CUSTOMER\n" +
                                        "JOIN INVOICE\n" +
                                        "ON CUSTOMER.cus_code=INVOICE.cus_code\n" +
                                        "JOIN LINE\n" +
                                        "ON INVOICE.inv_number=LINE.inv_number\n" +
                                        "JOIN PRODUCT\n" +
                                        "ON LINE.p_code=PRODUCT.p_code\n" +
                                        "WHERE CUSTOMER.cus_code="+Code);
    }
           
    int UpdateCustomer(
            String Code, 
            String updatedFName, 
            String updatedMInitial, 
            String updatedLName, 
            String updatedAreaCode, 
            String updatedPhone){
        return connection.executeUpdate("UPDATE CUSTOMER SET CUS_LNAME='"+updatedLName+"',CUS_FNAME='"+updatedFName+"', CUS_INITIAL='"+updatedMInitial+"', CUS_AREACODE='"+updatedAreaCode+"', CUS_PHONE='"+updatedPhone+"' WHERE CUS_CODE="+Code);
    }
    
}
