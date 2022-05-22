<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vaccine Document</title>
</head>
<style>
body {
	font-family: "Roboto", sans-serif;
	margin: 0;
	text-align: center;
	padding: 16px;
	font-size: 20px;
}
.header {
	 text-align: center;
        color: white;
        padding: 50px;
        background-color: #0bd257;
        height: 50px;
        font-size: 20px;
}
.footer {
	 padding: 5px;
        text-align: center;
        background-color: #f986ec;
        color: white;
        font-size: 20px;
        height: 50px;
}
.content {
	padding: 160px;
}
.button {
   background-color: #0815a2;
        border: none;
        color: white;
        padding: 15px 32px;
        text-align: right;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin: 4px 2px;
        cursor: pointer;
  
}
 .top-right {
            top: 0;
            right: 0;
        }
.button:hover {
  background-color: rgb(98, 98, 206);
}
.button1{
background-color: #0815a2;
        border: none;
        color: white;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin: 4px 2px;
        cursor: pointer;
  
}
.button1:hover {
  background-color: rgb(98, 98, 206);
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}
td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}
tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);

%>


<body>
 
<div class="header">
	<h1>Vaccine Databse Information</h1>	
		<a href="WellcomePage.jsp"><input type="submit" class=" button" value= "Logout" style="float: right;">	
		</a>
		
	</div>

	<div class="content"></div>
	
	<form action="Vaccine.data" method="post">
	<div>
	 <input type="submit"  value="Add Member" class="button1"><br>
	 </div>
	 </form>
		<table>
			<thead>
				<tr>
					<th>NAME</th>
					<th>GENDER</th>
					<th>DOB</th>
					<th>PHOTO_ID_PROOF</th>
					<th>ID_NUMBER</th>
					<th>VACCINE_TYPE</th>
					<th>DOSE</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${ListOfAddMemberDetails}" var="addMemberObj">
				<tr>
						<td>${addMemberObj.name}</td>
						<td>${addMemberObj.gender}</td>
						<td>${addMemberObj.dob}</td>
						<td>${addMemberObj.photoId}</td>
						<td>${addMemberObj.idNumber}</td>
						<td>${addMemberObj.vaccineType}</td>
						<td>${addMemberObj.dose}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
</body>
<div class="footer">
	<marquee>Get vaccinated to become healthy India</marquee>
</div>
</html>


