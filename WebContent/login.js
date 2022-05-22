function validate()
{
    var username=document.getElementById("username").value;
    var password=document.getElementById("password").value;
     if(username.length()<=5)
    {
        alert("username can not be small");
        return false;
    }
    else if(password.length()<=5)
    {
      alert("password can not be small");
      return false;
    }
}