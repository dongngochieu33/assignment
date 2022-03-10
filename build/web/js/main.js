function login(){
    document.getElementById("form-container").style.display = "block";

}
function logout(){
    window.location.href = "../logout";
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
function deleteOrder(url,shId,tienPhaiTra,cusId){
    var result = confirm("Bạn muốn xóa đơn hàng này khỏi danh sách nợ?");
     if(result){
                    window.location.href = url +"?shId="+shId+"&tienPhaiTra="+tienPhaiTra+"&cusId="+cusId;
                }
}