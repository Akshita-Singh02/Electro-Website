<%@page import="com.learn.mycart.entities.User"%>

<%
User user1=(User)session.getAttribute("current-user");


 

%>


<nav class="navbar navbar-expand-lg bg-body-tertiary custom-bg " >
    <div class="container"  >
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <a class="navbar-brand" href="index.jsp"><img
                    src="img/pole.png" 
                    alt="" 
                    width="35"
                    height="35"></a>
          <a class="navbar-brand" href="index.jsp"><b>Electro</b></a>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
      </ul>
        
        
         <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
           <li class="nav-item">
<!--               changing the quantity of the cart items-->
               <a class="nav-link active" aria-current="page" href="#" data-toggle="modal" data-target="#cart"><i class="fa fa-cart-plus" style="font-size: 30px;"></i> <span  class="ml-2 cart-items"style="font-size: 20px;">(4)</span></a>
           
           </li>
         
          <%
          if(user1==null)
          {
          %>
          <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="login.jsp">Login</a></li>
          <a class="nav-link active" aria-current="page" href="register.jsp">Register</a>
      <%
          
          }
          else{
      %>
      <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#"><%= user1.getUserName()%></a></li>
          <a class="nav-link active" aria-current="page" href="LogoutServlet">Logout</a>
      <%
          
           }
          
          %>
        </ul>
         </div>
          </div>
  </div>
</div>
</nav>
