tmwApp.controller('logoutController', ['$scope','$rootScope','$location', function($scope, $rootScope,$location){
    $scope.logout = function(){
    	   $rootScope.isUserLoggedIn = false;
		   $rootScope.username = "";
		   $rootScope.firstname = "";
		   $rootScope.lastname = "";
		   $location.url("/");
    };
}]);