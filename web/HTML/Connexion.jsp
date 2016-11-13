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
        <title>Interface de connexion</title>
    </head>
    <body>
        <h1>Connectez-vous</h1>
        
        <form id="formulaireConnexion">
            <input type="text" value="Entrez votre email" />
            <input type="password" value="Mot de passe" />
            <br /><br />
            <input type="submit" value="Connexion" />
        </form>
  
<script>
    var formulaireConnexion = document.getElementById('formulaireConnexion');
  
    myForm.addEventListener('submit', function(e) {
        alert('Vous avez envoyé le formulaire !\n\nMais celui-ci a été bloqué pour que vous ne changiez pas de page.');
        e.preventDefault();
    });
  
</script>
    </body>
</html>
