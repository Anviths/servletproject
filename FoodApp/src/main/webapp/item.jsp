<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="item">
ProductId:<input  type="number" name="item_id"><br><br>
Item Name:<input  type="text" name="item_name"><br><br>
Item Quantity:<input  type="text" name="item_quantity"><br><br>
Item Price:<input  type="number" name="item_price"><br><br>
ITEM Type <select name="item_type">
     <option value="VEG" >Veg
     <option value="NONVEG" >Non-Veg
  
     </select> <br><br>
     <input type="submit" value="Submit" >
</form>
</body>
</html>