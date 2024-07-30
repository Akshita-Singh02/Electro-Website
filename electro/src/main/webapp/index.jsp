
<%@page import="com.learn.mycart.helper.FactoryProvider,com.learn.mycart.dao.PrdDao,com.learn.mycart.dao.CategoryDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>
      
    </head>
    <body>
        <%@include file="components/common_css_js.jsp" %>
        <%@include file="components/navbar.jsp" %>
        <div class="container-fluid">
        <div class="row mt-3 mx-2">
            <%
               String cat= request.getParameter("category");
            PrdDao dao= new PrdDao(FactoryProvider.getFactory());
            //conditional rendering
            List<Product> list=null;
            if(cat==null || cat.trim().equals("all"))
            {
          list=dao.getAllProducts();
            
            }
           
            else{
            int cid=Integer.parseInt(cat.trim());
            list=dao.getAllProductsById(cid);
            }
            
            CategoryDao cdao=new CategoryDao(FactoryProvider.getFactory());
            List<Category> clist=cdao.getCategories();
            %>
<!--            show categories-->
            <div class="col-md-2">
                
                <div class="list-group">
                   
  <a href="index.jsp?category=all" class="list-group-item list-group-item-action active" aria-current="true">
    All products
  </a>
  
              
                <%
                for(Category cd:list)
                {
                %>
                <a href="index.jsp?category=<%=c.getCategoryId%>" class="list-group-item list-group-item-action"><%= c.getCategoryTitle()%></a>
                <%
                }
                
                
                %>
                
            </div>
<!-- show products-->
            <div class="col-md-10">
                
                <!--row-->
                <div class="row mt-4">
<!--                    col which is taking 12 grid alone-->
                    <div class="col-md-12">
                        <div class="card-columns">
<!--                            traversing products-->

 <%
                    for(Prd prd:list)
                    {
                   
                    %>
                    
<!--                    PRODUCT CARD-->

                    <div class="card">
                       <div class="container text-center">
                            <img src="img/products/<%=p.getpPhoto()%>" style="max-height: 200px;max-width: 100%;width: auto;" class="card-img-top m-2">
                          
                       </div>
                        <div class="card-body">
                            <h5 class="card-title"><%=prd.getpTitle()%></h5>
                            <p class="card-text">
                                
                                <%=Helper.get10Words(prd.getpDesc())%>
                            </p>
                        </div>
                            <div class="card-footer text-center">
                                <button class="btn custom-bg text-white" onclick="add_to_cart(<%= p.getpId()%>,<%= p.getpTitle()%>,<%= p.getpPrice%>)">add to cart</button>
                                
                                <button class="btn btn-outline-primary">&#8377;<%=prd.getPriceAfterDiscount()%>/- <span>&#8377;<%=prd.getpPrice()%>,<%=prd.getpDiscount()%>% off</span></button>
                            </div>
                    </div>
 
<%
                    }

if(list.size()==0)
{
out.println("<h3>no items in this category</h3>");
}
                    %>

                        </div>>
                    </div>
                </div>
                <h1>
                   
                </h1>
            </div>
        </div>
        </div>
                   
                    
                    <%@include file="components/common__modals.jsp" %>  
                    
                    
                   
       </body>
</html>
