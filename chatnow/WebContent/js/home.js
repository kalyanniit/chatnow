var chat=angular.module('chat',['ngRoute']);
chat.config(function($routeProvider)
{
$routeProvider.when('/register',
{
templateUrl:'views/register.html',
controller:'registerController'  
}).when('/login',
{
templateUrl : 'views/login.html',
controller : 'loginController'
}).when('/blog',
{
templateUrl : 'views/blog.html',
controller : 'blogController'
}).when('/forum',
{
	templateUrl : 'views/forum.html',
	controller : 'forumController'
	});
});   
chat.directive('fileModel', ['$parse', function ($parse) {
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

chat.service('fileUpload', ['$http','$location', function ($http,$scope,$location) {
    this.uploadFileToUrl = function(file, uploadUrl,username,password,emailid,contact){
       var fd = new FormData();
       fd.append('file', file);
       fd.append('username',username);
       fd.append('password',password);
       fd.append('emailid',emailid);
       fd.append('contact',contact);
    console.log("fd:"+fd)
       $http.post(uploadUrl, fd, {
          transformRequest: angular.identity,
          headers: {'Content-Type': undefined}
       })
    
       .success(function(){
    	   $scope.message="registered! you can login now!!";
    	    $scope.username="";
    	    $scope.password="";
    	   
       })
    
       .error(function(){
       });
    }
 }]);
chat.controller('registerController', ['$scope', 'fileUpload', function($scope,fileUpload){
	console.log("iam in register controllerrrrrr");
    $scope.register= function(){
       var file = $scope.myFile;
       var username=$scope.username;
       var password=$scope.password;
       var emailid=$scope.emailid;
       var contact=$scope.contact;
       console.log("username"+username);
       console.log("password:"+$scope.password);

       console.log("emailid:"+$scope.emailid);
       console.log("contact:"+$scope.contact);
       console.log('file is ' );
       console.dir(file);
       var uploadUrl = "http://localhost:8088/chatnow/fileUpload";
       fileUpload.uploadFileToUrl(file, uploadUrl,username,password,emailid,contact);
    };
 }]);


chat.controller('blogController', function($scope)
{
	console.log("iam in blog controller");
$scope.message="you are in blog page";
});
chat.controller('forumController', function($scope)
		{
	console.log("iam in forum controller");
		$scope.message="you are in forum page";
		});
