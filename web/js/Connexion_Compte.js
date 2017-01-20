function Connexion(){
    //var mailOk = verifMailConn(f.email);
    //var mdpOK = verif_champConn(f.mdp);
    //if(mailOk && mdpOK){
        var email = document.getElementById('email').value;
        var mdp = document.getElementById('mdp').value;
        //var params = email+"/"+mdp;
        var xmlhttp = new XMLHttpRequest();
        var url = "http://localhost:8080/E-DRIVE/webresources/Utilisateur/Connexionn/"+email+"/"+mdp;
        xmlhttp.open('GET',url,true);
        xmlhttp.send(null);
        xmlhttp.onreadystatechange = function() {
         
                if (xmlhttp.readyState == 4) {
                 if ( xmlhttp.status == 200) {
                    var resp = eval( "(" +  xmlhttp.responseText + ")"); 
                    
                    if (resp.reponse != null) {
                        alert(resp.reponse);
                    }
                    else{
                        
                        var monobjet_json = JSON.stringify(resp);
                        sessionStorage.setItem("objet",monobjet_json );
                        document.getElementById('profil').click();
                        
                    }
                 }
                 else {
                    alert("Error ->" + xmlhttp.responseText);
                 }
              }
        };


   // }
   /* else
    {
       alert("Veuillez remplir correctement tous les champs");
    }*/
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