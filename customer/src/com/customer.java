package com;
import java.sql.*; 
public class Item 
{ 
private Connection connect() 
 { 
 Connection con = null; 
 try
 { 
 Class.forName("com.mysql.jdbc.Driver"); 
 con = 
 DriverManager.getConnection( 
 "jdbc:mysql://locallhost/customer", "root", ""); 
 } 
 catch (Exception e) 
 { 
 e.printStackTrace(); 
 } 
 return con; 
 } 
public String customer() 
 { 
 String output = ""; 
 try
 { 
 Connection con = connect(); 
 if (con == null) 
 { 
 return "Error while connecting 
 to the database for reading."; 
 } 
 // Prepare the html table to be displayed
 output = "<table border='1'><tr><th>Item Code</th> 
 <th>customerID</th><th>phone</th>"
 + "<th>Item Description</th> 
 <th>Update</th><th>Remove</th></tr>"; 
 String query = "select * from customer"; 
 Statement stmt = con.createStatement(); 
 ResultSet rs = stmt.executeQuery(query); 
 // iterate through the rows in the result set
 while (rs.next()) 
 { 
 String customerID = Integer.toString(rs.getInt("customerID")); 
 String phone = rs.getString("phone"); 

String customerID = rs.getString("cusomer");
 String itemPrice = Double.toString( 
 rs.getDouble("product")); 
 String customer = rs.getString("customer"); 
 // Add into the html table
 output += "<tr><td><input id='hidcustomerUpdate' 
 name='hicustmerIDUpdate' 
 type='hidden' value='" + customer
 + "'>" + customer + "</td>"; 
 output += "<td>" + phone + "</td>"; 
 output += "<td>" + product + "</td>"; 
 output += "<td>" + payment + "</td>"; 
 // buttons
 output += "<td><input name='btnUpdate' 
 type='button' value='Update' 
 class='btnUpdate btn btn-secondary'></td>"
 + "<td><input name='btnRemove' 
 type='button' value='Remove' 
 class='btnRemove btn btn-danger' 
 data-itemid='"
 + itemID + "'>" + "</td></tr>"; 
 } 
 con.close(); 
 // Complete the html table
 output += "</table>"; 
 } 
 catch (Exception e) 
 { 
 output = "Error while reading the items."; 
 System.err.println(e.getMessage()); 
 } 
 return output; 
 } 
public String insertcustomer(String CustomerID, String phone, 
 String product, String payment) 
 { 
 String output = ""; 
 try
 { 
 Connection con = connect(); 
 if (con == null) 
 { 
 return "Error while connecting 
 to the database for inserting."; 
 } 
 // create a prepared statement
 String query = " insert into items 
 (`CustomerID`,`phone`,`product`,`payment`)"
8
+ " values (?, ?, ?, ?, ?)";
 PreparedStatement preparedStmt = con.prepareStatement(query); 
 // binding values
 preparedStmt.setInt(1, 0); 
 preparedStmt.setString(2, customerID); 
 preparedStmt.setString(3, phone); 
 preparedStmt.setDouble(4, product); 
 preparedStmt.setString(5, payment); 
 // execute the statement
 preparedStmt.execute(); 
 con.close(); 
 String newcustomer = readcustomer(); 
 output = "{\"status\":\"success\", \"data\": \"" + 
 newItems + "\"}"; 
 } 
 catch (Exception e) 
 { 
 output = "{\"status\":\"error\", \"data\": 
 \"Error while inserting the customer.\"}"; 
 System.err.println(e.getMessage()); 
 } 
 return output; 
 } 
public String updateItem(String ID, String phone, String product, 
 String payment) 
 { 
 String output = ""; 
 try
 { 
 Connection con = connect(); 
 if (con == null) 
 { 
 return "Error while connecting 
 to the database for updating."; 
 } 
 // create a prepared statement
 String query = "UPDATE items SET 
 itemCode=?,itemName=?,itemPrice=?,itemDesc=? WHERE itemID=?"; 
 PreparedStatement preparedStmt = con.prepareStatement(query); 
 // binding values
 preparedStmt.setString(1, CustomerID); 
 preparedStmt.setString(2, phone); 
 preparedStmt.setDouble(3, product); 
 preparedStmt.setString(4, payment); 
 

 // execute the statement
 preparedStmt.execute(); 
 con.close(); 
 String newItems = readItems(); 
 output = "{\"status\":\"success\", \"data\": \"" + 
 newItems + "\"}"; 
 } 
 catch (Exception e) 
 { 
 output = "{\"status\":\"error\", \"data\": 
 \"Error while updating the customer.\"}"; 
 System.err.println(e.getMessage()); 
 } 
 return output; 
 } 
public String deletecustomer(String customerID) 
 { 
 String output = ""; 
 try
 { 
 Connection con = connect(); 
 if (con == null) 
 { 
 return "Error while connecting 
 to the database for deleting."; 
 } 
 // create a prepared statement
 String query = "delete from customer where customerID=?"; 
 PreparedStatement preparedStmt = con.prepareStatement(query); 
 // binding values
 preparedStmt.setInt(1, Integer.parseInt(customerID)); 
 // execute the statement
 preparedStmt.execute(); 
 con.close(); 
 String newCustomer = customerItems(); 
 output = "{\"status\":\"success\", \"data\": \"" + 
 newItems + "\"}"; 
 } 
 catch (Exception e) 
 { 
 output = "{\"status\":\"error\", \"data\": 
 \"Error while deleting the item.\"}"; 
 System.err.println(e.getMessage()); 
 } 
 return output; 
 } 
}