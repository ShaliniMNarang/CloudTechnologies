// CONTROLLER Login User
tmwApp.controller('loginController', ['$scope', '$rootScope', '$http', '$location', function($scope, $rootScope, $http, $location){
	
   $scope.doLogin = function(){
       var username = $scope.username;
       var password = $scope.password;
       var url = "/api/loginUser";
       
      
       var data = new FormData();
       data.append('username', username);
       data.append('password', password);
       
       console.log(data.username + ":"+data.password);
       var config = {
    	   	transformRequest: angular.identity,
    	   	transformResponse: angular.identity,
	   		headers : {
	   			'Content-Type': undefined
	   	    }
       }
       
       $http.post(url, data, config).then(function (response) {
    	   if(response.data != "")  {
    		   console.log("logged in ");
    		   $rootScope.isUserLoggedIn = true;
    		   var res = response.data.split(":");
    		   $rootScope.username = res[0];
    		   $rootScope.firstname = res[1];
    		   $rootScope.lastname = res[2];
    		   $location.url("/filedetails");
    	   }
    	   else
    		   $rootScope.isUserLoggedIn = false;
		}, function (response) {
		});
    };
}]);
