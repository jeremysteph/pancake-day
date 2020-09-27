// load images
var pigImg = new Image();
var backGround = new Image();
var lowerPipe = new Image();
var upperPipe = new Image();

var cancelAnimationFrame = window.cancelAnimationFrame || window.mozCancelAnimationFrame;
var startAnimationFrame = window.requestAnimationFrame || window.mozRequestAnimationFrame ||
    window.webkitRequestAnimationFrame || window.msRequestAnimationFrame;
var globalID;

//variable list
var score = 0;
var gameCanvas;
var ctx;
var pipe = [];
var pigSnort = new Audio();
var pigSqueal = new Audio();
var pointEarned = new Audio();
var gap = 100;
var constant;
var pig;
var highestScore=[];
var keyIndex=0;
var vy = 0;




document.addEventListener("DOMContentLoaded", function () {
    gameCanvas = document.getElementById("gameCanvas");
    ctx = gameCanvas.getContext("2d");
    initiatePipes();
    initiateSoundEffects();
    welcomeScreen();
});

function initiateSoundEffects(){

    pigSnort.src = "./sounds/snort.mp3";
    pointEarned.src = "./sounds/addPoint.mp3";
    pigSqueal.src = "./sounds/squeal.mp3";
}
function initiatePipes() {
    pipe[0] = {
        x: gameCanvas.width,
        y: 0,

    };
}

class Pig {
    constructor(x, y) {
        this.x_ = x;
        this.y = y;
        this.img = pigImg;
        this.velocity_y = 0;
        this.angle = 0;
        this.flipV = false;
        this.flipH = false;
    }
}

function welcomeScreen() {

    ctx.font = "30px Comic Sans MS";
    ctx.fillStyle = "Green";
    ctx.textAlign = "center";
    ctx.fillText("Click to start", gameCanvas.width / 2, gameCanvas.height / 2);



    gameCanvas.addEventListener("click", draw);
    pig = new Pig(gameCanvas.width / 2, gameCanvas.height / 2);


}

function initGame() {
    //Sets the initial value of the pig's change in velocity
    vy = 0;

    gameCanvas.removeEventListener("click", initGame);
    ctx.clearRect(0, 0, gameCanvas.width, gameCanvas.height);
    pipe = [];
    initiatePipes();

    score = 0;


    draw();


}

pigImg.src = "./img/supaPig2.png";
backGround.src = "./img/desert.png";
lowerPipe.src = "./img/lowerPipe.png";
upperPipe.src = "./img/upperPipe.png";





function playerJumpAnim() {
    vy = vy - 35;
    pigSnort.play();

}

//Function to handle animation of pig when player taps the spaceBarKey on gameCanvas
function spaceBarKey(e) {

    if (e.keyCode == 32) {
        event.preventDefault();
        playerJumpAnim();

    }

}

//Function to handle animation of pig when player clicks on gameCanvas
function clickHandler() {

    playerJumpAnim();
}

function draw() {
    gameCanvas.removeEventListener("click", draw);

    pig.velocity_y = vy;

    globalID = startAnimationFrame(draw);
    ctx.drawImage(backGround, 0, 0);

    gameCanvas.addEventListener('keydown', this.spaceBarKey, false);
    gameCanvas.addEventListener('click', this.clickHandler, false);

    for (var i = 0; i < pipe.length; i++) {

        constant = upperPipe.height + gap;

        ctx.drawImage(upperPipe, pipe[i].x, pipe[i].y);
        ctx.drawImage(lowerPipe, pipe[i].x, pipe[i].y + constant);
        pipe[i].x--;
        playerDied(i);

        if (pipe[i].x == 450) {
            pipe.push({
                x: gameCanvas.width,
                y: Math.floor(Math.random() * upperPipe.height) - upperPipe.height
            });

        }
    }


    ctx.drawImage(pig.img, gameCanvas.width / 2, (gameCanvas.height / 2) + vy, 55, 55);

    vy += 1.5;

    ctx.fillStyle = "Green";
    ctx.font = "20px Comic Sans MS";
    ctx.fillText("Score : " + score, 55, gameCanvas.height - 20);


}



function playerDied(i) {


    if (pig.x_ + 48 >= pipe[i].x && pig.x_ <= pipe[i].x + upperPipe.width
        && (pig.velocity_y <= pipe[i].y || pig.velocity_y + pig.img.height >= pipe[i].y + constant - 160))
    // || pig.velocity_y + pig. >=  cvs.height)
    {

        gameOver();
    }


    if (vy > gameCanvas.height - 200 || vy < (gameCanvas.height - 150) * -1) {

        gameOver();
    }


    if (pipe[i].x == 420) {
        score++;
        
        pointEarned.play();
    }

    function gameOver() {
        pigSqueal.play();
        ctx.font = "50px Comic Sans MS";
        ctx.fillStyle = "Red";
        ctx.fillText("Game Over!", gameCanvas.width / 2, gameCanvas.height / 2);
        ctx.font = "20px Comic Sans MS";
        ctx.fillText("Click to play again!", gameCanvas.width / 2, gameCanvas.height / 1.5);
        checkForNewHighScore(score);
        gameCanvas.addEventListener("click", initGame);

        cancelAnimationFrame(globalID);
    }
function checkForNewHighScore(score){

    if(highestScore.includes(score)!=true){
        highestScore.push(score);
        addItemToLocalStorage(highestScore);

    }
}
    //adds items to local storage and increments key so storage items can remain locally 
function addItemToLocalStorage(highestScore){


 
         localStorage.setItem("highScore",highestScore);     

  
     
 }
 
}

