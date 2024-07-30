<%@page import="com.learn.mycart.entities.User,com.learn.mycart.dao.CategoryDao,com.learn.mycart.helper.FactoryProvider,java.util.*" %>

<%
User user=(User)session.getAttribute("current-user");
if(user==null)
{
session.setAttribute("message","You are not logged in!!");
response.sendRedirect("login.jsp");
return;
}
else{
if(user.getUserType().equals("normal"))
{
session.setAttribute("message","you are not admin!!");
response.sendRedirect("login.jsp");
return;
 }
}

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .card {
    background-color: #fff;
   
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0.1, 0.1, 0.1);
   
    
}
.card:hover{
     background: #F5F5F5;
    cursor: pointer;
}
        </style>
    </head>
    <body>
         <%@include file="components/common_css_js.jsp" %>
        <%@include file="components/navbar.jsp" %>
        <br>
        <div class="container">
            <div class="container fluid">
            <%@include file="components/message.jsp"%>
            </div>
            <div class="row mt-3">
                <div class="col-md-4">
                    <div class="card">
                        <div class="card-body text-center">
                            <div class="container">
                                <img style="max-width: 125px;" class="img-fluid " src="img/office-man.png">
                            </div>
                            <h1>123</h1>
                            <h1 class="text-uppercase text-muted">User</h1>
                        </div>
                    </div>
                </div><!-- comment -->
                <div class="col-md-4">
                    <div class="card">
                        <div class="card-body text-center">
                            <div class="container">
                                <img style="max-width: 125px;" class="img-fluid " src="img/category.png">
                            </div>
                            <h1>123</h1>
                            <h1 class="text-uppercase text-muted">Category</h1>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card">
                        <div class="card-body text-center">
                            <div class="container">
                                <img style="max-width: 125px;" class="img-fluid " src="img/box.png">
                            </div>
                            <h1>123</h1>
                            <h1 class="text-uppercase text-muted">Products</h1>
                        </div>
                    </div>
                </div>
            </div>    
            <br>
        <div class="row mt-2">
            <div class="col-md-6">
            <div class="card" data-bs-toggle="modal" data-bs-target="#add-category-md">
                <div class="card-body text-center">
                            <div class="container">
                                <img style="max-width: 125px;" class="img-fluid " src="img/plus.png">
                            </div>
                          
                            <h1 class="text-uppercase text-muted">Add category</h1>
                        </div>
            </div>
            </div>
            <div class="col-md-6">
             <div class="card" data-bs-toggle="modal" data-bs-target="#add-product-md">
                <div class="card-body text-center">
                            <div class="container">
                                <img style="max-width: 125px;" class="img-fluid " src="img/add-product.png">
                            </div>
                           
                            <h1 class="text-uppercase text-muted">Add products</h1>
                        </div>
            </div>
            </div>
        </div>
        </div>
<!--        add category modal-->


<!-- Modal -->
<div class="modal fade"  id="add-category-md" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" >
    <div class="modal-content">
      <div class="modal-header custom-bg">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Add category</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
          <form action="OperationServlet" method="post">
<!--          add this for letting server know it is for add category-->
          <input type="hidden" name="operation" value="addcategory">
           <div class="form-group">
               <input style="border-radius:9px ;border-color: black;" type="text" class="form-control" name="catTitle" placeholder="enter category " required/>
           </div>
           <br><!-- comment -->
           <div class="form-group">
               <textarea style="border-radius:9px ;border-color: black;" class="form-control" placeholder="enter category description" name="catDescription" required></textarea>
           </div>
           <br>
            <button type="submit" class="btn btn-outline-success">Add category</button>
                 <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
       </form>
          
          
      </div>
      <div class="modal-footer">
      <div class="container text-center">
                
       
           </div>
      </div>
    </div>
  </div>
</div>
<!--        add product modal-->


<!-- Modal -->
<div class="modal fade" id="add-product-md" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header custom-bg">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Add Product</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
          <form action="OperationServlet" method="post" enctype="multipart/form-data">
              <input type="hidden" name="operation" value="addproduct">
           <div class="form-group">
               <input style="border-radius:9px ;border-color: black;" type="text" class="form-control" name="pTitle" placeholder="enter product name" required/>
           </div>
           <br>
           <div class="form-group">
               <textarea style="border-radius:9px ;border-color: black;" class="form-control" placeholder="enter product description" name="pDescription" required></textarea>
           </div>
          
           <br>
           <div class="form-group">
               <input style="border-radius:9px ;border-color: black;" type="text" class="form-control" name="pPrice" placeholder="enter product price" required/>
           </div>
           <br>
           <div class="form-group">
               <input style="border-radius:9px ;border-color: black;" type="text" class="form-control" name="pDiscount" placeholder="enter product discount" required/>
           </div>
           <br>
           <div class="form-group">
               <input style="border-radius:9px ;border-color: black;" type="text" class="form-control" name="pQuantity" placeholder="enter product quantity" required/>
           </div>
           <br>
           
            <div class="form-group">
                <input style="border-radius:9px ;border-color: black;" type="text" class="form-control" name="pCategory" placeholder="enter product category" required/>
                  
                
           </div>
            <br>
           <div class="form-group">
               <label for="pPhoto">Select pic of product</label>
               <br>
               <br>
               <input  type="file" id="pPhoto" name="pPhoto" accept="image/*" required>
           </div>
            <br>
          <button type="submit" class="btn btn-outline-success">Add product</button>
                 <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
       </form>
          
      
      </div>
       <div class="modal-footer">
      <div class="container text-center">
                
       
           </div>
      </div>
    </div>
  </div>
</div>
    </body>
</html>
