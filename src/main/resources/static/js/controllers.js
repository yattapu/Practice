/**
 * Created by Sandeep on 01/06/14.
 */
angular.module('movieApp.controllers',[]).controller('MovieListController',function($scope,$state,popupService,$window,Movie){

    $scope.movies=Movie.getAllUsers();

    $scope.deleteMovie=function(movie){
        if(popupService.showPopup('Really delete this?')){
            movie.$delete(function(){
                $window.location.href='';
            });
        }
    }

}).controller('MovieViewController',function($scope,$stateParams,Movie){
var user = Movie.getUser({id:$stateParams.id});
console.log(user);
    $scope.movie=user;

}).controller('MovieCreateController',function($scope,$state,$stateParams,Movie){
    var user;
    Movie.insertUser(user, function(){
    
        $scope.movie.$save(function(){
            $state.go('movies');
        });
    });

}).controller('MovieEditController',function($scope,$state,$stateParams,Movie){

    $scope.updateMovie=function(){
        $scope.movie.$update(function(){
            $state.go('movies');
        });
    };

    $scope.loadMovie=function(){
        $scope.movie=Movie.getUser({id:$stateParams.id});
    };

    $scope.loadMovie();
});