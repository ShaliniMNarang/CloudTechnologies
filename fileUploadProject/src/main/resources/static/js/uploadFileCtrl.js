// CONTROLLER UPLOAD FILE
tmwApp.controller('uploadFileController', ['$scope', '$rootScope', '$http', function($scope,$rootScope, $http){
    $scope.doUploadFile = function(){
       var file = $scope.uploadedFile;
       var url = "/api/uploadfile";
       var description = $scope.description;
       
       var size = file.size;
       if(size > 1000000)
    	   alert("file size is above 10 MB, hence aborting upload");
       else {
	       var data = new FormData();
	       data.append('uploadfile', file);
	       data.append('username',$rootScope.username);
	       data.append('description',description);
	    
	       var config = {
	    	   	transformRequest: angular.identity,
	    	   	transformResponse: angular.identity,
		   		headers : {
		   			'Content-Type': undefined
		   	    }
	       }
	       
	       $http.post(url, data, config).then(function (response) {
				$scope.uploadResult=response.data;
			}, function (response) {
				$scope.uploadResult=response.data;
			});
       }
    };
}]);
