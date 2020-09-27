
window.addEventListener("DOMContentLoaded", () => {

    const operTile = document.querySelector("#operand_Tile");
    const operTileAns = document.querySelector("operandTileAns");
 operTile.addEventListener("click", event => {
    const answer = operandTile.getAttribute("answer");
  operTileAns.innerHTML = answer;
  window.setTimeout(function(){
      answer.innerHTML = "Click to see the answer!";
  }, 2300);
});


    const addBtn = document.querySelector("#addBtn");
    addBtn.addEventListener("click", event => {
        document.getElementById("operand_section").style.display = "block";
        getOperand("add");
    });
        const subBtn = document.querySelector("#subBtn");
        subBtn.addEventListener("click", event => {
            document.getElementById("operand_section").style.display = "block";
            getOperand("sub");
    });

    const multiBtn = document.querySelector("#mulBtn");
    multiBtn.addEventListener("click", event => {
        document.getElementById("operand_section").style.display = "block";
        getOperand("multi");
});

const modBtn = document.querySelector("#modBtn");
modBtn.addEventListener("click", event => {
    document.getElementById("operand_section").style.display = "block";
    getOperand("modular");
});

const divBtn = document.querySelector("#divBtn");
divBtn.addEventListener("click", event => {
    document.getElementById("operand_section").style.display = "block";
    getOperand("div");
});
document.querySelector("#divBtn")

});

      
     

function getOperand(buttonSelected){
    randomNumberGenerator(buttonSelected);

    var operandSym;

   if(buttonSelected =="add"){
    operandSym = "+";

   }

   if(buttonSelected =="sub"){
        operandSym ="-";
}
  if(buttonSelected =="div"){
    operandSym="/";
}

if(buttonSelected =="multi"){
    operandSym="x";
}
    if(buttonSelected =="modular"){
        operandSym="%";
    }
    

   randomNumberGenerator(operandSym);
}

function randomNumberGenerator(operand){

    const num1 =  Math.floor(Math.random()*50);
    const num2 =  Math.floor(Math.random()*50);
 
 

  
    document.getElementById("operand").innerHTML=num1 + " " + operand + " " + num2 +" =";
    document.getElementById("operand").innerHTML+="<div id=\"operand_Tile\" answer=\"answer\" style=\"border-bottom: 0\" class=\"btn btn-primary tooltip\">?"+
    "<div class=\"top\"><h3 id=\"operandTileAns\">Click to see the answer!</h3><i></i></div>";


performOperand(operand,num1,num2)
 
}

function performOperand(operand,num1,num2){
    var result;

    if(operand =="+"){
        result = num1+num2;
    }
    if(operand =="-"){
        result = num1-num2;

     }

     if(operand =="x"){
        result = num1*num2;

     }


     if(operand =="/"){
        result = num1/num2;

     }

     if(operand =="%"){
        result = num1%num2;

     }

     document.getElementById('operand_Tile').onclick = function() {
        document.getElementById('operandTileAns').innerHTML=result;
        window.setTimeout(function(){
            document.getElementById('operandTileAns').innerHTML = "Click to see the answer!";
        }, 2300);
     }

}



