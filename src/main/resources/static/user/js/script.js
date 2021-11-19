
function openNav() {
    document.getElementById("mySidenav").style.width = "480px";
}
  
function closeNav() {
    document.getElementById("mySidenav").style.width = "0"; 
}

function fun1() {
  
  var checkbox;
  checkbox = document.getElementById('chbox');
  
  if(checkbox.checked){
    alert('Choosed');
  }
  else{
    alert('Not choosed');
  }
}
  