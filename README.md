# online_shopping_system

This Java program simulates a basic online shopping system. It allows users to browse products, add items to their shopping cart, view the cart, and proceed to checkout. The program also includes user authentication, requiring users to log in before accessing certain features.

1. Class Overview
OnlineShoppingSystem: The main class that contains the program's entry point (main method) and handles the user interface.
Product: Represents a product in the store, with attributes for ID, name, and price.
ShoppingCart: Manages the list of products added by the user, provides methods to add/remove items, and calculate the total cost.
User: Represents a user in the system with a username and password for authentication.
2. Main Flow of the Program
Initialization:

The program starts by initializing a list of available products (e.g., Laptop, Smartphone, Headphones, Clothes).
A ShoppingCart instance is created to store the items the user will add.
The user is prompted with a menu to interact with the system.
Menu Options:

Login/Logout (Option 1):
If the user is not logged in, they are prompted to enter their username and password.
Successful login grants access to additional options. If already logged in, this option logs the user out.
Browse Products (Option 2):
Displays a list of available products, including their ID, name, and price. Users can view the products before adding them to the cart.
Add Product to Cart (Option 3):
This option is available only when the user is logged in.
The user is prompted to enter the ID of the product they wish to add to their cart.
The selected product is added to the ShoppingCart.
View Cart (Option 4):
Displays the contents of the shopping cart, including the names and prices of added products.
The total cost of the items in the cart is also shown.
Checkout (Option 5):
This option is available only when the user is logged in.
Clears the cart and simulates the completion of the purchase with a thank-you message.
Exit (Option 6):
Ends the program.
3. Detailed Method Descriptions
login():

Prompts the user for a username and password.
Validates the credentials against hardcoded values (username: sharath, password: 1234).
If valid, the user is logged in; otherwise, an error message is shown.
logout():

Logs the current user out and sets the currentUser variable to null.
browseProducts(Product[] products):

Loops through the array of products and prints out each product's ID, name, and price.
addProductToCart(Product[] products):

Prompts the user to enter the product ID they wish to add to the cart.
The method searches for the product in the array by its ID.
If found, the product is added to the ShoppingCart. If not, an error message is displayed.
viewCart():

Retrieves the list of items in the ShoppingCart.
If the cart is empty, a message is displayed. Otherwise, it lists each item and the total price.
checkout():

Simulates the checkout process by thanking the user for their order and clearing the cart.
4. User Interaction Flow
Upon starting the program, the user sees a menu. If they have not logged in, they are prompted to do so to access the cart or checkout options.
The user can browse products, add items to their cart, view the cart's contents, and proceed to checkout after logging in.
The program loops, allowing the user to perform multiple actions until they choose to exit.
