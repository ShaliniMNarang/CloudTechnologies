tmwApp.controller('downloadFileController', ['$scope','$rootScope', '$window','$http', function($scope, $rootScope,$window, $http){
    $scope.downloadFile = function(username1,filename1, keyname1){
       var url = "/api/downloadFile";
      
       $http.get(url,
    		   {
    	    		params: { username: $rootScope.username, 
    	    				filename: filename1, keyname: keyname1 }}).then(function (response) {
    	    					var blob = new Blob([response.data]);
    	    					var a = window.document.createElement("a");
    	    					a.href = window.URL.createObjectURL(blob, {type: 'image/jpeg;charset=UTF-8'});
    	    					a.download = filename1;
    	    					document.body.appendChild(a);
    	    					a.click();
    	    					document.body.removeChild(a);
			
		});
    };
}]);
