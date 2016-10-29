<%-- 
    Document   : index
    Created on : 14 oct. 2016, 15:41:08
    Author     : Abdelkarim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>UberPermis</h1>
        
        <script>
       
        var xmlhttp = new XMLHttpRequest();
        
        function getdetails() {
        var url = "http://localhost:8080/ServiceUberPermis/webresources/Personne/1";
        xmlhttp.open('GET',url,true);
        xmlhttp.send(null);
        xmlhttp.onreadystatechange = function() {

               if (xmlhttp.readyState == 4) {
                  if ( xmlhttp.status == 200) {
                       var res = eval( "(" +  xmlhttp.responseText + ")");
                       alert(res.nom);
                 }
                 else
                       alert("Error ->" + xmlhttp.responseText);
              }
        };
    }
    getdetails();
    
    </script>
    </body>
</html>
