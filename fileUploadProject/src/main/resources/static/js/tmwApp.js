var tmwApp = angular.module('tmwApp', ['ngRoute']);

tmwApp.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "login.html"
    }).when('/filedetails', {
       // controller: Ctrl2,
        templateUrl : "filedetails.html"
    });
});

// DIRECTIVE - FILE MODEL
tmwApp.directive('fileModel', ['$parse', function ($parse) {
    return {
       restrict: 'A',
       link: function(scope, element, attrs) {
          var model = $parse(attrs.fileModel);
          var modelSetter = model.assign;
          
          element.bind('change', function(){
             scope.$apply(function(){
                modelSetter(scope, element[0].files[0]);
             });
          });
       }
    };
}]); 