angular.module('supaPigApp', [])
.controller('supaPigControler', function ($scope,$http) {

  $scope.highestScore=0;
       
      $scope.init = function() {
   
        $scope.width=800;
        $scope.height=450;
        $scope.loadGameInfo();
        $scope.updateHighScore();
      }
  

      $scope.loadGameInfo = function(){
    $http.get("./games.json").then(function (json) {
  
      $scope.gameTitle = json.data[0].title;
      $scope.gameInstructions = json.data[0].instructions.join("");
       console.log(json.data[0].title);
       console.log($scope.gameInstructions);

     
  }
  
  );


  
  }

  $scope.updateHighScore = function(){

if(localStorage.getItem('highScore') != null){
   $scope.highScore = JSON.parse(localStorage.getItem('highScore'));
   console.log($scope.highScore);
   $scope.highestScore = Math.max(highScore);
}
}
}
);