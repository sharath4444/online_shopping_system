package online_shoppin_system;
import java.util.*;
import java.lang.*;
public class OnlineShoppingSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static ShoppingCart cart = new ShoppingCart();
    private static User currentUser = null;

    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", 999.99),
            new Product(2, "Smartphone", 499.99),
            new Product(3, "Headphones", 99.99),
            new Product(4, "Clothes", 399)
        };

        boolean exit = false;
        while (!exit) {
            System.out.println("==== Online Shopping System ====");
            if (currentUser == null) {
                System.out.println("1. Login");
            } else {
                System.out.println("1. Logout");
            }
            System.out.println("2. Browse Products");
            if (currentUser != null) {
                System.out.println("3. Add Product to Cart");
                System.out.println("4. View Cart");
                System.out.println("5. Checkout");
            }
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (currentUser == null) {
                        login();
                    } else {
                        logout();
                    }
                    break;
                case 2:
                    browseProducts(products);
                    break;
                case 3:
                    if (currentUser != null) {
                        addProductToCart(products);
                    } else {
                        System.out.println("Please login to add products to your cart.");
                    }
                    break;
                case 4:
                    if (currentUser != null) {
                        viewCart();
                    } else {
                        System.out.println("Please login to view your cart.");
                    }
                    break;
                case 5:
                    if (currentUser != null) {
                        checkout();
                    } else {
                        System.out.println("Please login to checkout.");
                    }
                    break;
                case 6:
                    exit = true;
                    System.out.println("Thank you for shopping with us!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        }
    }

    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if ("sharath".equals(username) && "1234".equals(password)) {
            currentUser = new User(username, password);
            System.out.println("Login successful.");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private static void logout() {
        currentUser = null;
        System.out.println("Logout successful.");
    }

    private static void browseProducts(Product[] products) {
        System.out.println("==== Products ====");
        for (Product product : products) {
            System.out.println(product.getId() + ". " + product.getName() + " - Rs :" + product.getPrice());
        }
        System.out.println();
    }

    private static void addProductToCart(Product[] products) {
        System.out.println("Enter the product ID to add to cart: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product selectedProduct = null;
        for (Product product : products) {
            if (product.getId() == productId) {
                selectedProduct = product;
                break;
            }
        }

        if (selectedProduct != null) {
            cart.addItem(selectedProduct);
            System.out.println(selectedProduct.getName() + " has been added to your cart.");
        } else {
            System.out.println("Invalid product ID. Please try again.");
        }
    }

    private static void viewCart() {
        System.out.println("==== Shopping Cart ====");
        List<Product> items = cart.getItems();
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            for (Product item : items) {
                System.out.println(item.getName() + " - Rs :" + item.getPrice());
            }
            System.out.println("Total: Rs :" + cart.calculateTotal());
        }
    }

    private static void checkout() {
        System.out.println("Thank you for your order!");
        cart.clearCart();
    }
}
