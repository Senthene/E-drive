
function verifFormConn(f){
    var mailOk = verifMailConn(f.email);
    var mdpOK = verif_champConn(f.mdp);
    if(mailOk && mdpOK){
        var email = document.getElementById('email').value;
        var mdp = document.getElementById('mdp').value;
        
        var xmlhttp = new XMLHttpRequest();
        var url = "http://localhost:8080/E-DRIVE/webresources/Utilisateur/Connexion/";
        xmlhttp.open('GET',url,true);
        xmlhttp.send('mail=' + email + '&mdp=' + mdp);

    }
    else
    {
       alert("Veuillez remplir correctement tous les champs");
    }
}

function verif_champConn(champ) {
    if (champ.value == "") {
        //alert("Le champs "+champ+" n'est pas renseigné");
        surligne(champ, true);
        return false;
    }
    surligne(champ, false);
    return true;
}
// Vérification du champs Email
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