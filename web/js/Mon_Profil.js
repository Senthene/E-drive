function hide(){
    var form = document.getElementById("modifier");
    var paragraphe = document.getElementById("paragraphe");
    if(form.style.display == "none" && paragraphe.style.display == "block"){
        form.style.display = "block";
        paragraphe.style.display = "none";
    }   
    else {
        form.style.display = "none"; 
        paragraphe.style.display = "block";
    }
}