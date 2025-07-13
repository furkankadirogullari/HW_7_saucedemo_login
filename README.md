# 🧪 SauceDemo Login Test Automation

This project contains Selenium WebDriver test cases written in Java using JUnit 5.  
It performs automated login tests on the [SauceDemo](https://www.saucedemo.com/) website using different user types and validates error messages for failed login attempts.

---

## 📁 Project Structure

saucedemo-login-tests/
├── pom.xml
└── src
├── main
│ └── java
└── test
└── java
└── com
└── furkan
└── saucedemo
└── SauceDemoLoginTest.java

## ✅ Features

- Login tests with valid users:
  - `standard_user`
  - `problem_user`
  - `performance_glitch_user`
- Negative test case with `locked_out_user`
- Validation of proper error messages:
  - Missing username or password
  - Invalid credentials
  - Locked out user message


## 🔧 Technologies Used

- Java 17+
- Selenium WebDriver 4.21.0
- JUnit 5
- Maven (build & dependency management)

## 🚀 How to Run

1. **Clone the repository**

git clone https://github.com/furkankadirogullari/HW_7_saucedemo_login.git
cd HW_7_saucedemo_login

2. **Install dependencies**

mvn clean install

3. **Run tests**

mvn test

4. **View results**

Chrome browser will open and close automatically

For development/debugging, you can delay browser closing using Thread.sleep() in the @AfterEach method

🧪 Sample Test Scenarios
Scenario	                    Expected Result
Login with standard_user	    Success
Login with locked_out_user	    Error message: "Sorry, this user has been locked out."
Login without password	        Error message: "Password is required"
Login with invalid credentials	Error message: "Username and password do not match..."


🙋 Author
Furkan Kadiroğulları
📧 furkankadirogullari@gmail.com





