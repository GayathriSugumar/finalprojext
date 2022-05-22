<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wellcome Page</title>
<style>
      header .header {
        background-color: #fff;
        height: 45px;
       
    }
    
    header a img {
        width: 134px;
        margin-top: 4px;
    }
    
    .login-page {
        width: 360px;
        padding: 8% 0 0;
        margin: auto;
    }
    
    .login-page .form .login {
        margin-top: -31px;
        margin-bottom: 26px;
    }
    
    .form {
        position: relative;
        z-index: 1;
        background: #FFFFFF;
        max-width: 360px;
        margin: 0 auto 100px;
        padding: 45px;
        text-align: center;
        box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
    }
    
    .form input {
        font-family: "Roboto", sans-serif;
        outline: 0;
        background: #f2f2f2;
        width: 100%;
        border: 0;
        margin: 0 0 15px;
        padding: 15px;
        box-sizing: border-box;
        font-size: 14px;
    }
    
    .form button {
        font-family: "Roboto", sans-serif;
        text-transform: uppercase;
        outline: 0;
        background-color: #328f8a;
        background-image: linear-gradient(45deg, #328f8a, #08ac4b);
        width: 100%;
        border: 0;
        padding: 15px;
        color: #FFFFFF;
        font-size: 14px;
        -webkit-transition: all 0.3 ease;
        transition: all 0.3 ease;
        cursor: pointer;
    }
    
    .form .message {
        margin: 15px 0 0;
        color: #b3b3b3;
        font-size: 12px;
    }
    
    .form .message a {
        color: #4CAF50;
        text-decoration: none;
    }
    
    .container {
        position: relative;
        z-index: 1;
        max-width: 300px;
        margin: 0 auto;
    }
    
    body {
        background-color: #328f8a;
        background-image: linear-gradient(45deg, #328f8a, #08ac4b);
        font-family: "Roboto", sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
    }
</style>
</head>

<body>
<div class="header">
		<a href="Registration"><input type="submit" class="button2" value= "Register Here" style="float:right;">
		</a>
		</div>
		
	<h2>${message}</h2>
		<form action="wellcome.data" method="post">
		
    <div class="login-page">
        <div class="form">
            <div class="login">
                <div class="login-header">
                    <h3>LOGIN</h3>
                    
                </div>
                <label for="email"> Email </label>
                <input type="text" name="email" id="email" placeholder="email" size="15" required />
            </div>
            
            <form class="login-form">
                <button type="submit">Verified</button>
            </form>
     </div>
   </div>
		
</form>	
</body>
<div class="footer">
	<marquee>Get vaccinate to become healthy India</marquee>
</div>
</html>


			
			
			
	
	
	