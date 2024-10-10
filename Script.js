var data;
var form = document.getElementById("enroll_FORM");
form.addEventListener("submit" , s);
function s(e)
{

    e.preventDefault();
    var name = form.inputName3.value;
    var email= form.inputEmail3.value;
    var web = form.inputWebsite3.value;
    var img_link = form.inputImage3.value;

    var x = form.gridRadios1;
    var y = form.gridRadios2;
    if(x.checked == true)
       var gender = x.value;
    else if(y.checked == true)
        var gender = y.value;
    else
        return false;

    var skills = new Array();
    var x = form.inlineCheckbox1;
    for(var i=0; i<x.length; i++){
        if(x[i].checked)
             skills.push( x[i].value);
    }
   
    if (validate_name(name)==1)
        return false

    else if (validate_email(email)==1)
        return false

    else if (validate_web(web)==1)
        return false;
    
    else if (validate_img(img_link)==1)
        return false;
    
    else if (validate_skills(skills)==1)
        return false;
    
    else{}

    var skill="";
    for (var i=0;i<skills.length;i++){
        skill=skill+skills[i]+" ";
    }

    data={
        name:name,
        email:email,
        web:web,
        img_link:img_link,
        gender:gender,
        skill:skill  }

    arr = JSON.parse(localStorage.getItem("user")) ? JSON.parse(localStorage.getItem("user")) : []
    arr.push(data);
    localStorage.setItem("user",JSON.stringify(arr)); 
      
    view();
    document.getElementById("enroll_FORM").reset();

}


function view(){
    if(localStorage.getItem("user") != null){
        var output= document.querySelector("tbody");
        output.innerHTML=``;
        let lis=JSON.parse(localStorage.getItem("user"));
        lis.forEach(i => {
            output.innerHTML +=`
            <tr>
            <td><b>${i.name}</b><br>
              ${i.gender}<br>
              ${i.email}<br>
              <a href= "${i.web}" target= "_blank"> ${i.web} </a> <br>
              ${i.skill}
            </td>
            <td> <center>  <img src="${i.img_link}" style="width:100px ; height:100px;"/> </center>  </td>
            </tr> 
            `
        });
    }
    else{
        var output= document.querySelector("tbody");
        output.innerHTML=``;
    }
}
        
function clear_data(){
    localStorage.clear();
    view();
}

function validate_name(name){
    if(name.trim()==""){
        alert("Empty Name");
         return 1;}
    else
        return 0;
}

function validate_email(email){
    if(email.trim()==""){
        alert("Empty Email");
         return 1;}
    else
        return 0;
}

function validate_web(web){
    var regex1 = /^https/;

    if(web.trim()==""){
        alert("Empty Website Link");
        return 1;}
    else if(regex1.test(web)==false){
        alert("Invalid Website Link");
        return 1;}
    else
        return 0;
    
}

function validate_img(web){
    var regex1 = /^https/;

    if(web.trim()==""){
        alert("Empty Image Link");
        return 1;}
    else if(regex1.test(web)==false){
        alert("Invalid Image Link");
        return 1;}
    else
        return 0;
    
}

function validate_skills(skills){
    if(skills.length==0){
        alert("No Skills Marked");
        return 1;}
    else
        return 0;
}

