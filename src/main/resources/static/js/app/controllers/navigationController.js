'use strict';

appControllers.controller('navigationController',['$rootScope','$scope',function($rootScope, $scope){
    $rootScope.authenticated = false;
    
    $scope.login = function() {
        $rootScope.authenticated = true;
    };
    
    $scope.logout = function() {
        $rootScope.authenticated = false;
    };
}]);