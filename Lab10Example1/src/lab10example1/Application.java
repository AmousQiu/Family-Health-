package lab10example1;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author syedmfaizan
 */
public class Application {
    private UserInterface UI=null;
    private MysqlDatabaseConnection dbConnection=null;
    private Scanner scanner = null;
    private Boolean isRunning=true;
    
    void start(){
        this.initialize();
        this.run();
    }
    
    void initialize(){
        this.scanner = new Scanner(System.in);
        this.UI = new UserInterface();
        MysqlDatabaseConnection dbConnection = new MysqlDatabaseConnection();
        if(dbConnection.connect())
        {
            this.dbConnection=dbConnection;
        }
        else{
            this.isRunning=false;
            this.UI.printInitializationError();
        }
    }
    
    void run(){
        UI.printWelcomeGreetings();
        while(this.isRunning){
            UI.printMainMenu();
            int mainOption = Integer.parseInt(scanner.nextLine());
            switch(mainOption){
                case 1: viewCustomer();
                        break;
                case 2: updateCustomer();
                        break;
                case 3: viewCustomerProducts();
                        break;
                case 999: this.exit();
                        break;
                default: System.out.println("Incorrect Option selected");
            }
            System.out.flush();
        }
    }
    
    void exit(){
        this.dbConnection.disconnect();
        this.scanner.close();
        this.isRunning=false;
    }
    
    void viewCustomer(){
        Boolean backPressed = false;
        while(!backPressed){
            this.UI.printViewCustomerMenu();
            int customerOption = Integer.parseInt(scanner.nextLine());
            switch(customerOption){
                case 1: viewAllCustomers();
                        break;
                case 2: viewCustomerByCode();
                        break;
                case 999: backPressed=true;
                        break;
                default: System.out.println("Incorrect Option selected");
            }
        }
    }
    
    void viewAllCustomers(){
        CustomerCRUD customerService = new CustomerCRUD(dbConnection);
        ResultSet rs = customerService.getAllCustomers();
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println(rsmd.getColumnName(1) + "  " + rsmd.getColumnName(2) + "  " + rsmd.getColumnName(3));
            while(rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
        } catch (SQLException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void viewCustomerByCode(){
        CustomerCRUD customerService = new CustomerCRUD(dbConnection);
        UI.printEnterCustomerCodeText();
        String customerCode = scanner.nextLine();
        ResultSet rs = customerService.getCustomerByCode(customerCode);
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println(rsmd.getColumnName(1) + "  " + rsmd.getColumnName(2) + "  " + rsmd.getColumnName(3));
            while(rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
        } catch (SQLException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void updateCustomer(){
        CustomerCRUD customerService = new CustomerCRUD(dbConnection);
        UI.printEnterCustomerCodeText();
        String customerCode = scanner.nextLine();
        ResultSet rs = customerService.getCustomerByCode(customerCode);
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println(rsmd.getColumnName(1) + "  " + rsmd.getColumnName(2) + "  " + rsmd.getColumnName(3));
            while(rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
        
            UI.printEnterCustomerNewFName();
            String updatedFName=scanner.nextLine();
            UI.printEnterCustomerNewMInitial();
            String updatedMInitial=scanner.nextLine();
            UI.printEnterCustomerNewLName();
            String updatedLName=scanner.nextLine();
            UI.printEnterCustomerNewAreaCode();
            String updatedAreaCode=scanner.nextLine();
            UI.printEnterCustomerNewPhone();
            String updatedPhone=scanner.nextLine();
            int updated = customerService.UpdateCustomer(customerCode,updatedFName,updatedMInitial,updatedLName,updatedAreaCode,updatedPhone);
            if(updated==1)
                System.out.println("Customer Updated!");
        } catch (SQLException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void viewCustomerProducts(){
        CustomerCRUD customerService = new CustomerCRUD(dbConnection);
        UI.printEnterCustomerCodeText();
        String customerCode = scanner.nextLine();
        ResultSet rs = customerService.getCustomerProducts(customerCode);
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println(rsmd.getColumnName(1) + "  " + rsmd.getColumnName(2) + "  " + rsmd.getColumnName(3));
            while(rs.next())
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  $" + rs.getString(3));
        } catch (SQLException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
