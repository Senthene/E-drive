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
         <link rel="stylesheet" href="CSS/index.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <div class="Menu">
                <div class="header-Menu">
                    <div class="header-Menu-logo">
                        <a class="header-logo" href="index.jsp" title="Revenir à l'accueil de E-Drive, le moteur de recherche des cours de conduites">E-Drive</a>
                    </div>
                    <div class="header-Menu-item">
                        <ul>
                            <li><a href="Création_Compte.html">S'incrire</a></li>
                            <li><a href="Connexion.jsp">Se connecter</a></li>
                            <li><a href="#about">A propos</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </header>
        <div class="Home">
            <img src="images/Acceuil.jpg"/>        
        </div>
        
        
        <script>
       
        var xmlhttp = new XMLHttpRequest();
        
        function getdetails() {
        var url = "http://localhost:8080/ServiceUberPermis/webresources/Moniteur/benkaddour.abdellkarim@gmail.com";
        xmlhttp.open('POST',url,true);
        //xmlhttp.send(null);
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
