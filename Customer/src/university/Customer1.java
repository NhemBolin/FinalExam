package university;

import java.util.Scanner;

// Interface representing the discount rate
interface DiscountRate {
    double getServiceDiscount(String type);
    double getProductDiscount(String type);
}

// Customer class implementing the DiscountRate interface
class Customer implements DiscountRate {
    @Override
    public double getServiceDiscount(String type) {
        return switch (type) {
            case "Premium" -> 0.2;
            case "Gold" -> 0.15;
            case "Silver" -> 0.1;
            default -> 0.0;
        }; // 20% discount
        // 15% discount
        // 10% discount
        // 0% discount for Normal
    }

    @Override
    public double getProductDiscount(String type) {
        switch (type) {
            case "Premium":
            case "Gold":
            case "Silver":
                return 0.1; // 10% discount for Premium, Gold, Silver
            default:
                return 0.0; // 0% discount for Normal
        }
    }
}

// Sale class for interaction with user input and output
class Sale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();

        System.out.print("Enter customer type (Premium, Gold, Silver, Normal): ");
        String customerType = scanner.next();

        double serviceDiscount = customer.getServiceDiscount(customerType);
        double productDiscount = customer.getProductDiscount(customerType);

        System.out.println("Service Discount for " + customerType + ": " + (serviceDiscount * 100) + "%");
        System.out.println("Product Discount for " + customerType + ": " + (productDiscount * 100) + "%");

        scanner.close();
    }
}