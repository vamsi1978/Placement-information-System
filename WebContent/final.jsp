<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<html>
    <head>
        <title>
            Welcome
        </title>
        <link rel="stylesheet" href="final.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        
        <nav>
            <ul>
              <li><a href="index.html">Log out</a></li>
            </ul>
            <ul>
          <input class="s" type="text" name="search" placeholder="Search with id">
          <i class="fa fa-search" aria-hidden="true"></i>
           </ul>
        </nav>
        <br>
        <br>
        <div  class="data">
        
        
        <%

    String driver = "oracle.jdbc.driver.OracleDriver";
    String connectionUrl = "jdbc:oracle:thin:@localhost:1521:XE";
    String userid = "hr";
    String password = "hr";
    try {
      Class.forName(driver);
      }
    catch (ClassNotFoundException e) {
    e.printStackTrace();
    }
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    %>
        
        
        <%
        try{
          connection = DriverManager.getConnection(connectionUrl, userid, password);
          statement=connection.createStatement();
          String sql ="select * from studentdetails";
          resultSet = statement.executeQuery(sql);
          while(resultSet.next()){
        %>
        
       <h4>Student Id:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=resultSet.getString("name") %></h4>
      

       <br>
       <h4>Student Name:</h4>
  
     
       <br>
       <h4>Student Mail Adress:</h4>
  
        
       <br>
       <h4>Student Cgpa:</h4>
   
        
       <br>
       <h4>Student Credits:</h4>
     
         <br>
       <h4>Placement Offers:</h4>
       
       <br>
       <h4>Average Package:</h4>
     
       <br>
       <hr style="border:4px solid black">
    
    <%
    }
      connection.close();
      } catch (Exception e) {
      e.printStackTrace();
}
%>
 
      </div>
    </body>
</html>