package DataBaseTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {

Connection con;
Statement stmt;
ResultSet rs;
WebDriver driver = new ChromeDriver();
String  customerName;
String  customerLastName;
String  customerEmail;
String  Password;

@BeforeTest
	public void setup() throws SQLException {
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","1234");
	driver.get("https://smartbuy-me.com/ar/account/register");
}

	
@Test (priority=1 , enabled=false)
public void InsertInToDataBase() throws SQLException {
String query = "INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, city, country, salesRepEmployeeNumber, creditLimit) VALUES (999, 'New Corp', 'Smith', 'John', '123456789', '123 Main St', 'Los Angeles', 'USA', 1370, 50000.00);";
stmt = con.createStatement();
int RowEffected = stmt.executeUpdate(query);
System.out.print(RowEffected);
}



@Test (priority=2)
public void UpdateInToDataBase() throws SQLException {
String query = "UPDATE customers SET creditLimit = 75000 WHERE customerNumber = 999;";
stmt = con.createStatement();
int RowEffected = stmt.executeUpdate(query);
System.out.print(RowEffected);
}


@Test (priority=3)
public void ReadCustomerName() throws SQLException {
String query = "SELECT * FROM customers WHERE customerNumber = 999;";
stmt = con.createStatement();
rs= stmt.executeQuery(query);

while(rs.next()) {
	customerName = rs.getNString("contactFirstName");
	System.out.print(customerName);
}
	driver.findElement(By.id("customer[first_name]")).sendKeys(customerName);
	
}
	
	@Test (priority=4)
	public void ReadCustomerLasrName() throws SQLException {
	String query = "SELECT * FROM customers WHERE customerNumber = 999;";
	stmt = con.createStatement();
	rs= stmt.executeQuery(query);

while(rs.next()) {
	customerLastName = rs.getNString("contactLastName");
	System.out.print(customerName);
}
	driver.findElement(By.id("customer[last_name]")).sendKeys(customerLastName);
	}

	
	@Test (priority=5)
	public void ReadCustomerEmail() throws SQLException {
	String query = "SELECT * FROM customers WHERE customerNumber = 999;";
	stmt = con.createStatement();
	rs= stmt.executeQuery(query);

while(rs.next()) {
	customerEmail =customerName + "." + customerLastName + "@gmail.com";  
	System.out.print(customerEmail);
}
	driver.findElement(By.id("customer[email]")).sendKeys(customerEmail);
	}

	@Test (priority=5)
	public void ReadPassword() throws SQLException {
	String query = "SELECT * FROM customers WHERE customerNumber = 999;";
	stmt = con.createStatement();
	rs= stmt.executeQuery(query);

	while(rs.next()) {
		Password = rs.getNString("phone");
		System.out.print(Password);
	}
		driver.findElement(By.id("customer[password]")).sendKeys(Password);
		}
}
