<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
 <script src="Components/jquery-3.2.1.min.js">
 </script> <script src="Components/items.js"></script>
</head>
<body>
<div class="container"><div class="row"><div class="col-6"> 
<h1>CUSTOMER Management V10.1</h1> <form id="formItem" name="formItem">
 customerID: 
 <input id="customer" name="customer" type="text" 
 class="form-control form-control-sm">
 <br> Item name: 
 <input id="customerid" name="customerid" type="text" 
 class="form-control form-control-sm">
 <br> Item price: 
 <input id="phone" name="phone" type="text" 
 class="form-control form-control-sm">
 <br> Item description: 
 <input id="product" name="product" type="text" 
 class="form-control form-control-sm">
 <br>
 <input id="btnSave" name="btnSave" type="button" value="Save" 
 class="btn btn-primary">
 <input type="hidden" id="hidItemIDSave" 
 name="hidcustomerSave" value="">
</form> <div id="alertSuccess" class="alert alert-success"></div> <div id="alertError" class="alert alert-danger"></div> <br> <div id="divItemsGrid">
 <%
 customer customerObj = new customer(); 
 out.print(customerObj.readcustomer()); 
 %>
</div>
</div> </div> </div>

</body>
</html>