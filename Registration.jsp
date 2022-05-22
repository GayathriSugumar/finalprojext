<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    body {
        background-color: #328f8a;
        background-image: linear-gradient(45deg, #328f8a, #08ac4b);
        font-family: "Roboto", sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
    }
    
    .container {
        width: 100%;
        padding: 70px;
        background-color: rgb(144, 255, 238);
        position: relative;
        z-index: 1;
        max-width: 300px;
        margin: 0 auto;
    }
    
    form {
        width: 100%;
        margin: 50px auto;
        padding: 100px;
    }
    
    input[type=text],
    input[type=password],
    textarea {
        width: 100%;
        padding: 15px;
        margin: 5px 0 22px 0;
        display: inline-block;
        border: none;
        background: #f1f1f1;
    }
    
    input[type=text]:focus,
    input[type=password]:focus {
        background-color: rgb(16, 90, 174);
        outline: none;
    }
    
    div {
        padding: 10px 0;
    }
    
    hr {
        border: 1px solid #f1f1f1;
        margin-bottom: 25px;
    }
    
    .registerbtn {
        background-color: #0ba334;
        color: rgb(18, 1, 1);
        padding: 16px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
        opacity: 0.9;
    }
    
    .registerbtn:hover {
        opacity: 1;
    }
</style>
</head>
<body>
	<h2>${message}</h2>
	<form action="Registration.data" method="post">
  <div class="container">
        <center>
            <h1> Vaccine Registeration Form</h1>
        </center>
        <hr>
        <label for="name"> Name </label>
        <input type="text" name="name" placeholder="name" size="15" required />

        <div>
            <label for="gender">
            Gender :
        </label><br>
            <input type="radio" value="Male" name="gender" checked> Male
            <input type="radio" value="Female" name="gender"> Female
            <input type="radio" value="Other" name="gender"> Other

        </div>
        <div>
            <label for="mobile"> Mobile number: </label>
            <input type="password" name="password" placeholder="password" size="15" required />
        </div>

        <div>
            <label for="password"> Password: </label>
            <input type="text" name="mobile" placeholder="mobile" size="15" required />
        </div>

        <button type="submit" class="registerbtn">Save</button>
    </div>
</body>
<div class="footer">
	<marquee>Get vaccinate to become healthy India</marquee>
</html>