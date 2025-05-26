# PinarOnline UI Automation Tests

This project is a UI test automation suite developed in Java using Selenium WebDriver and TestNG. It is designed to automatically test various functionalities of the PinarOnline website.

---

## Tested Modules

1. **LoginPage (Login Tests)**  
   - User login via phone number  
   - OTP (One-Time Password) verification  
   - Verifying user login via the visibility of the profile icon  

2. **CategoryAndProductPage (Category & Product Tests)**  
   - Opening the category bar  
   - Clicking a random category  
   - Clicking a random product  
   - Verifying navigation to the product detail page  

3. **BasketPage (Basket Tests)**  
   - Adding a product to the basket  
   - Verifying the basket addition notification  
   - Increasing/decreasing product quantity in the basket  
   - Navigating to the basket and verifying the product  
   - Deleting the product from the basket  

4. **PromotionsPage (Promotions Tests)**  
   - Navigating to the promotions page  
   - Verifying that the promotion images are loaded properly  

---

## Project Structure

- **`pages`**: Contains Page Object Model (POM) classes that define web elements and page-specific actions.  
- **`tests`**: Includes all test cases, organized using the TestNG framework.  
- **`util`**: Utility classes such as WebDriver management.

---

## Technologies & Tools Used

- **Java 17+**  
- **Selenium + Selenium WebDriver**  
- **TestNG**  
- **Maven** (for dependency and build management)  
- **Explicit Waits (WebDriverWait)** for synchronization  

---

## How to Run

1. Clone the project from GitHub or your source repository.  
2. Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).   
3. Run test classes using your test runner (TestNG).

To run with Maven:

```bash
mvn test

To run a specific test class:

mvn test -Dtest=LoginTest
