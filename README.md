# ElectricityBillingSystem


ABSTRACT
Electricity billing is a crucial aspect of utility management, but traditional methods often lead to inefficiencies, delays, and inaccuracies. Customers are frequently required to visit electricity board offices for bill payments, which is both time-consuming and inconvenient. Manual calculations also increase the chances of errors, leading to disputes and discrepancies in billing. To overcome these challenges, this project introduces a computerized Electricity Billing System that automates the entire billing process, making it more efficient and user-friendly.
The system is developed using Java Swing for the user interface and MySQL for backend database management. It includes two types of users: Admin and Customer. The admin is responsible for managing customer details, recording monthly electricity usage, and overseeing bill calculations. Once the usage data is entered, the system automatically computes the bill based on predefined tariffs and updates the customer’s account. Customers can log in to their accounts to check their electricity consumption, view their generated bills, and make payments before the due date.
By shifting to an automated billing system, the project eliminates the need for physical visits, minimizes human errors, and enhances accessibility. The secure database ensures proper storage of customer records, payment history, and usage statistics, making tracking and management seamless. This system not only improves the efficiency of bill generation but also provides a convenient, transparent, and reliable solution for both customers and electricity providers. Our goal is to modernize the billing process, ensuring accuracy, efficiency, and ease of access in electricity bill payments.


---

## 🚀 Features

- 👥 **Login System** with roles: Admin and Customer
- 🧾 **Customer Module**: Add, view, and update customer data
- ⚙️ **Meter Information**: Add/view meter location, type, and phase
- 📆 **Billing**: Generate monthly bills based on units consumed
- 💳 **Payment**: Pay bills via Paytm integration (opens browser)
- 📊 **Reports**: View payment status and historical billing
- 🔐 **Secure**: Role-based access and validation

---

## 🛠️ Tech Stack

- **Frontend**: Java Swing (GUI)
- **Backend**: Java
- **Database**: MySQL
- **IDE**: IntelliJ IDEA / Eclipse / NetBeans
- **Tools**: JDBC, MySQL Workbench

---

🛠️ Setup Instructions
1. Clone the Repository
git clone https://github.com/yourusername/electricity-billing-system.gitcdelectricity-billing-system

2. Setup MySQL Database
Open the .txt file located in the database/ folder using MySQL Workbench or any MySQL client.
Execute the script to create all necessary tables:
login
customer
meter_info
bill
tax_rent
You can insert sample data provided in the file or add your own.

3. Configure JDBC Connection
Ensure the MySQL JDBC Driver (mysql-connector-java-x.x.xx.jar) is added to your project’s classpath.
Open the Conn.java file (or your database connection class).
Update the database URL, username, and password as per your local MySQL setup.

Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "yourUsername", "yourPassword");

4. Run the Application
Compile and run the Login.java file (your entry point).
Use the sample credentials from the login table to log in as Admin or Customer.

🔗 Paytm Integration
The Paytm.java class attempts to open the Paytm Online Payment page using the system’s default browser.

For systems that do not support JEditorPane to render external web content, it is recommended to use java.awt.Desktop instead.
