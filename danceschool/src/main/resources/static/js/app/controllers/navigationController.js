'use strict';

appControllers.controller('navigationController',['$rootScope','$scope', '$anchorScroll', '$location', 'activitiesService', '$log', 'ActivityType', function($rootScope, $scope, $anchorScroll, $location, activitiesService, $log, ActivityType){
    $rootScope.authenticated = false;
    
    $scope.login = function() {
        $rootScope.authenticated = true;
    };
    
    $scope.isCollapsed = true;
    
    $scope.logout = function() {
        $rootScope.authenticated = false;
    };

    $scope.status = {
        isopen: false
    };

    $scope.toggleDropdown = function($event) {
        $event.preventDefault();
        $event.stopPropagation();
        $scope.status.isopen = !$scope.status.isopen;
    };
    
    $scope.goToTop = function() {
        $location.hash('top');
        $anchorScroll();
    };

    $rootScope.loadModernDance = function() {
        activitiesService.loadModernDance();
        $log.info("broadcast modernActivity");
        $rootScope.activityType = ActivityType.MODERN;
        $rootScope.$broadcast('activityChange');
        $rootScope.$broadcast('activitiesLoaded');
    };
    $rootScope.loadBallroomDance = function() {
        activitiesService.loadBallroomDance();
        $rootScope.activityType = ActivityType.BALLROOM;
        $rootScope.$broadcast('activityChange');
        $rootScope.$broadcast('activitiesLoaded');
    };
    $rootScope.loadSpecialOccasionDance = function() {
        activitiesService.loadSpecialOccasionDance();
        $rootScope.activityType = ActivityType.SPECIAL_OCCASION;
        $rootScope.$broadcast('activityChange');
        $rootScope.$broadcast('activitiesLoaded');
    };
}]);