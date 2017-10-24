tmwApp.controller('getFilesController', ['$scope','$rootScope', '$http', function($scope, $rootScope,$http){
    $scope.doGetFiles = function(){
       var url = "/api/getallfiles";
      
       $http.get(url,{
    	    params: { username: $rootScope.username}}).then(function (response) {
			$scope.fileDetails = response.data;
		}, function (response) {
			alert(response.data);
		});
    };
}]);
