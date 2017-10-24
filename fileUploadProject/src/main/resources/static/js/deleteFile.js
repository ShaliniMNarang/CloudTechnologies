tmwApp.controller('deleteFileController', ['$scope', '$rootScope', '$http', '$route', function($scope, $rootScope, $http, $route){
	
   $scope.deleteFile = function(username,keyname){
       
       var url = "/api/deletefile";
       
      
       var data = new FormData();
       data.append('username', username);
       data.append('filekeyname', keyname);
       
       var config = {
       	   	transformRequest: angular.identity,
       	   	transformResponse: angular.identity,
   	   		headers : {
   	   			'Content-Type': undefined
   	   	    }
          }
            
       $http.post(url, data, config).then(function (response) {
    	   console.log("file deleted");
    	   $route.reload();
    		   
		}, function (response) {
		});
    };
}]);
