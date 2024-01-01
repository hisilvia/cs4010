<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.math.BigInteger" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Input Page</title>

<script>
   function setTaxRateForCity() {
	   document.getElementById("myrate").value = document.getElementById("mycity").value;
   }
   
   function generateRandomNum() {
	   const xhttp = new XMLHttpRequest();
	   
	   xhttp.onload = function() {
	     document.getElementById("gennumdisp").innerHTML = this.responseText;
	     document.getElementById("myresult").value = this.responseText;
	     }
	   
	   xhttp.open("GET", "generate", true);
	   xhttp.send();
	 }
   
   function decomposeRandomNum() {
	   const xhttp = new XMLHttpRequest();
	   var bigint = document.getElementById("gennumdisp").innerHTML;
	   
	   xhttp.onload = function() {
	     document.getElementById("decnumdisp").innerHTML = this.responseText;
	     //document.getElementById("myresult").value = this.responseText;
	    
	     }
	   
	   xhttp.open("GET", "decompose?bigint="+bigint, true);
	   xhttp.send();
	 }
   
   
</script>

</head>
<body>

   Operating system version is: "<%= request.getAttribute("client") %>"
   <br/> 
   <h2>Select a city</h2>
   <br/> 
         
 <form method="post" action="printServlet">
   <input type="hidden" id="myresult" name="myresult" value="" />
   
   
  Cities: <select id="mycity" name="city" onchange="setTaxRateForCity()" >
     <c:forEach var="city" items="${cityRate.cities}" varStatus="status">
      <option value="${status.index}">${city}</option>
    </c:forEach>
  </select>
  
  
  Tax Rates: <select id="myrate" name="tax rates" >
    <c:forEach var="rate" items="${cityRate.taxRates}" varStatus="status">
      <option value="${status.index}">${rate}</option>
    </c:forEach>
  </select><br /><br />
  
  <input type="button" onclick="generateRandomNum()" name="Generate" value="Generate" />
  <span id="gennumdisp"></span>
  <br /><br />
 
  <input type="button" onclick="decomposeRandomNum()" name="Decompose" value="Decompose" />
  <span id="decnumdisp"></span>
  <br /><br />
  <input type="submit" name="Calculate" value="Calculate" />
  
  
</form>
   

   
   
</body>
</html>

	   