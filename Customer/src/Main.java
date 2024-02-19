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
        return switch (type) {
            case "Premium", "Gold", "Silver" -> 0.1;
            default -> 0.0;
        }; // 10% discount for Premium, Gold, Silver
        // 0% discount for Normal
    }
}

// Sale class for interaction with user input and output
class Sale {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Customer customer = new Customer();
            
            System.out.print("Enter customer type (Premium, Gold, Silver, Normal): ");
            String customerType = scanner.next();
            
            double serviceDiscount = customer.getServiceDiscount(customerType);
            double productDiscount = customer.getProductDiscount(customerType);
            
            System.out.println("Service Discount for " + customerType + ": " + (serviceDiscount * 100) + "%");
            System.out.println("Product Discount for " + customerType + ": " + (productDiscount * 100) + "%");
        }
    }
}