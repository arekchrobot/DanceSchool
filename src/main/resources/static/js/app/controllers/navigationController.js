'use strict';

appControllers.controller('navigationController',['$rootScope','$scope', '$anchorScroll', '$location', function($rootScope, $scope, $anchorScroll, $location){
    $rootScope.authenticated = false;
    
    $scope.login = function() {
        $rootScope.authenticated = true;
    };
    
    $scope.logout = function() {
        $rootScope.authenticated = false;
    };

//    $scope.items = [
//        'The first choice!',
//        'And another choice for you.',
//        'but wait! A third!'
//    ];

    $scope.status = {
        isopen: false
    };

//    $scope.toggled = function(open) {
//        $log.log('Dropdown is now: ', open);
//    };

    $scope.toggleDropdown = function($event) {
        $event.preventDefault();
        $event.stopPropagation();
        $scope.status.isopen = !$scope.status.isopen;
    };
    
    $scope.goToTop = function() {
        $location.hash('top');
        $anchorScroll();
    };
}]);