📦 **ecommerce-cart-checkout**
A modular Selenium automation framework built with Java, Maven, and TestNG. It simulates a complete ecommerce flow — from landing on the site to adding products to the cart, checking out, and validating order confirmation.

🚀 **Features**
-> Page Object Model (POM) design for maintainability

-> Reusable components for reporting, waits, and data handling

-> TestNG-based test execution with grouped suites

-> ExtentReports integration for rich HTML reporting

-> Screenshot capture on failure

-> CI/CD ready with Maven and Jenkins compatibility

🧱 **Project Structure
Code**
src/
├── main/
│   └── java/
│       ├── seleniumproject.pageobject/       # Page classes (Cart, Checkout, etc.)
│       └── seleniumproject.resources/        # AbstractComponents, ExtentReports, global data
├── test/
│   └── java/
│       ├── seleniumproject/                  # Test cases (Login, SubmitOrder, etc.)
│       └── testcomponents/                   # BaseTest, Listeners
packages/
├── testng.xml                                # Master suite
├── purchase.xml                              # Purchase flow suite
├── Errorvalidationgroup.xml                  # Error validation suite
reports/
├── index.html                                # ExtentReports output
├── loginerrorvalidation.png                  # Screenshot example
pom.xml                                        # Maven config


🧪 **Test Scenarios Covered**
-> Login with valid and invalid credentials
-> Add product to cart and validate cart contents
-> Checkout flow with address and payment
-> Order confirmation validation
-> Login page Error handling and retry logic

⚙️ **Tools & Technologies Used**
-> Java 8
-> Selenium WebDriver
-> TestNG
-> Maven
-> ExtentReports
-> Jenkins (optional for CI/CD)

📂 **How to Run**
Clone the repo:
git clone https://github.com/yourusername/ecommerce-cart-checkout.git
Navigate to project folder and run:

**mvn clean test**
📸 Sample Report
Check reports/index.html after execution for detailed test results.
