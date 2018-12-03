package lab10example1;

/**
 *
 * @author syedmfaizan
 */
public class UserInterface {
    
    void printWelcomeGreetings(){
        System.out.println("Welcome to Sample Java MYSQL Connection Application!");
    }
    
    void printMainMenu(){
        System.out.println("Select Operation from List:");
        System.out.println("1: View Customer(s)");
        System.out.println("2: Update Customer");
        System.out.println("3: Products Sold to Customers");
        System.out.println("999: Exit Application");
    }
    
    void printViewCustomerMenu(){
        System.out.println("\tSelect Operation from List:");
        System.out.println("\t1: View All Customers");
        System.out.println("\t2: View Customer by Customer Code");
        System.out.println("\t999: Back");
    }
    
    void printEnterCustomerCodeText(){
        System.out.print("Enter Customer Code: ");
    }
    
    void printEnterCustomerNewFName(){
        System.out.print("Enter Updated First Name: ");
    }
    
    void printEnterCustomerNewMInitial(){
        System.out.print("Enter Updated Middle Initial: ");
    }
    
    void printEnterCustomerNewLName(){
        System.out.print("Enter Updated Last Name: ");
    }
    
    void printEnterCustomerNewAreaCode(){
        System.out.print("Enter Updated Area Code: ");
    }
    
    void printEnterCustomerNewPhone(){
        System.out.print("Enter Updated Phone Number: ");
    }
    
    void printInitializationError(){
        System.out.println("Application Cannot Initialize!");
    }
    
}
