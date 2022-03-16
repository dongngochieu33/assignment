function login(){
    document.getElementById("form-container").style.display = "block";

}
function logoutdenied(){
    window.location.href = "logout";
} 
function logout(){
    window.location.href = "../logout";
} function logout2(){
    window.location.href = "../../logout";
} 
 function submitForm() {
             document.getElementById("searchForm").submit();
            } 
  function paggerHome(id,pageindex,totalpage,addressid)
{
    container = document.getElementById(id);
    var result = '';
    result += '<div id="pageBox"> Page:<input id="pageindex_input" type="number" value="'+pageindex+'"/> over '+totalpage + '</div>';
    container.innerHTML = result;
    
    // Get the input field
    var input = document.getElementById("pageindex_input");

    // Execute a function when the user releases a key on the keyboard
    input.addEventListener("keyup", function(event) {
      // Number 13 is the "Enter" key on the keyboard
      if (event.keyCode === 13) {
            window.location.href = 'home?page='+input.value +"&addressid="+addressid; 
      }
    });
}
 function paggerTotalOwe(id,pageindex,totalpage,cusId,cusName,fromDate)
{
    container = document.getElementById(id);
    var result = '';
    result += '<div id="pageBox"> Page:<input id="pageindex_input" type="number" value="'+pageindex+'"/> over '+totalpage + '</div>';
    container.innerHTML = result;
    
    // Get the input field
    var input = document.getElementById("pageindex_input");

    // Execute a function when the user releases a key on the keyboard
    input.addEventListener("keyup", function(event) {
      // Number 13 is the "Enter" key on the keyboard
      if (event.keyCode === 13) {
            window.location.href = 'customer?page='+input.value +"&cusId="+cusId +"&cusName="+cusName +"&fromDate="+fromDate; 
      }
    });
}
 function paggerSaleDetail(id,pageindex,totalpage,saleHistoryId)
{
    container = document.getElementById(id);
    var result = '';
    result += '<div id="pageBox"> Page:<input id="pageindex_input" type="number" value="'+pageindex+'"/> over '+totalpage + '</div>';
    container.innerHTML = result;
    
    // Get the input field
    var input = document.getElementById("pageindex_input");

    // Execute a function when the user releases a key on the keyboard
    input.addEventListener("keyup", function(event) {
      // Number 13 is the "Enter" key on the keyboard
      if (event.keyCode === 13) {
            window.location.href = 'detail?page='+input.value +"&saleHistoryId="+saleHistoryId; 
      }
    });
}
function deleteOrder(url,shId,tienPhaiTra,cusId,cusName){
    var result = confirm("Bạn muốn xóa đơn hàng này khỏi danh sách nợ?");
     if(result){
                    window.location.href = url +"?shId="+shId+"&tienPhaiTra="+tienPhaiTra+"&cusId="+cusId+"&cusName="+cusName;
                }
}
function deleteAllOrderHistory(id){
    var result = confirm("Ban chắc chắn đã thanh toán đơn hàng này rồi?");
     if(result){
                    document.getElementById(id).submit();
                }
}
function deleteAllOrder(id,cid){
    console.log(cid);
     var result = confirm("Ban chắc chắn muốn xóa khách hàng này khỏi danh sách nợ?");
     if(result){
                    document.getElementById(id).submit();
                }
}
function deleteAllOrderCompany(id,name){
     var result = confirm("Bạn chắc chẵn đã thanh toán hết tiền nợ cho công ty " + name +" rồi?");
     if(result){
                    document.getElementById(id).submit();
                }
}

function openNav() {
  document.getElementById("mySidebar").style.width = "250px";
  document.getElementById("main").style.marginLeft = "250px";
}
function closeNav() {
  document.getElementById("mySidebar").style.width = "0";
  document.getElementById("main").style.marginLeft= "0";
}
function paggerTotalCompanyOwe(id,pageindex,totalpage,cid,cname,fromDate){
    container = document.getElementById(id);
    var result = '';
    result += '<div id="pageBox"> Page:<input id="pageindex_input" type="number" value="'+pageindex+'"/> over '+totalpage + '</div>';
    container.innerHTML = result;
    
    // Get the input field
    var input = document.getElementById("pageindex_input");

    // Execute a function when the user releases a key on the keyboard
    input.addEventListener("keyup", function(event) {
      // Number 13 is the "Enter" key on the keyboard
      if (event.keyCode === 13) {
            window.location.href = 'company?page='+input.value +"&cid="+cid +"&cname="+cname +"&fromDate="+fromDate; 
      }
    });
}
function paggerTotalDetailCompanyOwe(id,pageindex,totalpage,orderSaleId){
     container = document.getElementById(id);
    var result = '';
    result += '<div id="pageBox"> Page:<input id="pageindex_input" type="number" value="'+pageindex+'"/> over '+totalpage + '</div>';
    container.innerHTML = result;
    
    // Get the input field
    var input = document.getElementById("pageindex_input");

    // Execute a function when the user releases a key on the keyboard
    input.addEventListener("keyup", function(event) {
      // Number 13 is the "Enter" key on the keyboard
      if (event.keyCode === 13) {
            window.location.href = 'detail?page='+input.value +"&orderSaleId="+orderSaleId; 
      }
    });
}