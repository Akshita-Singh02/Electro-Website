
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            

.center-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%;
    width: 100%;
}

.centered-image {
    max-width: 100%;
    height: auto;
}
            </style>
    </head>
    <body>
        <%@include file="components/common_css_js.jsp" %>
        <%@include file="components/navbar.jsp" %>
         <br>
             <br>
              <br>
             <br>
         <div class="center-container">
            
        <img src="img/Group.png" alt="Centered Image" class="centered-image">
    </div>
        
    </body>
</html>
