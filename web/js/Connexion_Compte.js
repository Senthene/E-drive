
function verifFormConn(f){
    var mailOk = verifMailConn(f.email);
    var mdpOK = verif_champConn(f.mdp);
    if(mailOk && mdpOK){
        var email = document.getElementById('email').value;
        var mdp = document.getElementById('mdp').value;
        //var params = email+"/"+mdp;
        var xmlhttp = new XMLHttpRequest();
        var url = "http://localhost:8080/E-DRIVE/webresources/Utilisateur/Connexion/"+email+"/"+mdp;
        xmlhttp.open('GET',url, true);
        xmlhttp.send(null);
        xmlhttp.onreadystatechange = function(){ alertContents(xmlhttp); };

    }
    else
    {
       alert("Veuillez remplir correctement tous les champs");
    }
}
 function alertContents(http){
            //try {
                if (http.readyState == 4) {
                   if ( http.status == 200 && http.readyState == XMLHttpRequest.DONE) {
                        var resp = eval( "(" +  http.responseText + ")");
                        //var resp = xmlhttp.responseText;
                        if (resp.mail == email) {
                        //if (resp.echec != null) {
                            alert("Bonjour" + resp.dateInscription);
                       }
                       else 
                       {
                           alert("Le mot de passe et le user n'existe pas.");
                       }
                    }
                }
           // }
           // catch( e ) {
            //    alert("Une exception s'est produite : " + e.description);
           // }
        }
function verif_champConn(champ) {
    if (champ.value == "") {
        //alert("Le champs "+champ+" n'est pas renseignÃ©");
        surligne(champ, true);
        return false;
    }
    surligne(champ, false);
    return true;
}
// VÃ©rification du champs Email
function verifMailConn(champ){
    var regex = /^[a-zA-Z0-9._-]+@[a-z0-9._-]{2,}\.[a-z]{2,4}$/;
    if(!regex.test(champ.value))
    {
       surligne(champ, true);
       return false;
    }
    else
    {
        return true;
    }
}
function surligne(champ, erreur) {
   if(erreur)
      champ.style.backgroundColor = "#fba";
   else
      champ.style.backgroundColor = "";
}