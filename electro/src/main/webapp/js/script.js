function add_to_cart(pid,pname,price)
{
    let cart=localStorage.getItem("cart");
    if(cart == null)
    {
        //no cart yet
        let products=[];
        let product={productId:pid, productName:pname,productQuantity:1,productPrice: price};
        products.push(product);
        localStorage.setItem("cart",JSON.stringify(products));
    }
    else
    {
        //cart already present
        let pcart=JSON.parse(cart);//array
        pcart.find((item)=>item.productId == pid)
        if(oldProduct)
        {
            //we have to increase the quantity
            oldProduct.productQuantity=oldProduct.productQuantity+1
       pcart.map((item)=>
       {
           if(item.productId == oldProduct.productId)
           {
               item.productQuantity=oldProduct.productQuantity;
           }
       }) 
       localStorage.setItem("cart,JSON.stringify(pcart");
        
        
        }
        else{
            //we have to add the product
             let product={productId:pid, productName:pname,productQuantity:1,productPrice: price};
         pcart.push(product);
         localStorage.setItem("cart,JSON.stringify(pcart");
        }
    }
     updateCart()
   
}






//update cart

function updateCart()
{
    let cartString=localStorage.getItem("cart");
    let cart=JSON.parse(cartString);
    if(cart==null || cart.length==0)
    {
        $(".cart-items").html("(0)");//with the help of jquery we are setting this to 0 whenevr cart is null 
        $(".cart-body").html("<h3>cart does not have any items</h3>");
        $(".checkout-btn").addClass('disabled');
    
    }
    else
    {
        //there is something to show
        
        $(".cart-items").html(`(${cart.length})`);//with the help of jquery we are setting this to 0 whenevr cart is null 
        let table=`<table class='table'>
        <thead class='thead-light'>
        <tr>
        <th>Item Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Total Price</th>
        <th>Action</th>
        
        </tr>
        
        </thead>
        
   


`;//to traverse every item and put data inside it
        let totalPrice=0;
        cart.map((item)=>{
            table+=`
<tr>
            <td>${item.productName}</td>
            <td>${item.productPrice}</td>
            <td>${item.productQuantity}</td>
            <td>${item.productQuantity*item.productPrice}</td>
            <td><button  onclick='deleteItemFromCart(${item.productId})' class='btn btn-danger btn-sm'>Remove</button></td>
            </tr>


`//to apend in the table
            totalPrice+=item.productPrice*item.productQuantity;
            
            
        })//to traverse every item turn by turn
       table=table+` 
<tr>
<td colspan='5' class='text-right font-weight-bold m-5'> Total Price:${totalPrice}</td>
</tr>

</table>` 
         $(".cart-body").html(table);//to insert the table
    }
}


//remove item
function deleteItemFromCart(pid)
{
        let cart=JSON.parse(localStorage.getItem('cart'));
let newcart=cart.filter((item)=>item.productId!=pid)//to filter out product with this id
localStorage.setItem('cart',JSON.stringify(newcart));
updateCart();//to update GUI changes

}

$(document).ready(function(){
    
    updateCart()
})