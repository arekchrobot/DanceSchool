'use strict';

appControllers.controller('navigationController', ['$rootScope', '$scope', '$anchorScroll', '$location', '$log', 'ActivityType', 'localStorageService',
    function ($rootScope, $scope, $anchorScroll, $location, $log, ActivityType, localStorageService) {
        $rootScope.authenticated = false;

        $scope.login = function () {
            $rootScope.authenticated = true;
        };

        $scope.isCollapsed = true;

        $scope.logout = function () {
            $rootScope.authenticated = false;
        };

        $scope.status = {
            isopen: false
        };

        $scope.toggleDropdown = function ($event) {
            $event.preventDefault();
            $event.stopPropagation();
            $scope.status.isopen = !$scope.status.isopen;
        };

        $scope.goToTop = function () {
            $location.hash('top');
            $anchorScroll();
        };

        var setActivityInLocalStorage = function(activityType) {
            if(localStorageService.isSupported) {
                localStorageService.set('activityType', activityType);
            }
        }

        $rootScope.loadModernDance = function () {
            setActivityInLocalStorage(ActivityType.MODERN);
            $rootScope.activityType = ActivityType.MODERN;
            $rootScope.$broadcast('activityChange');
        };
        $rootScope.loadBallroomDance = function () {
            setActivityInLocalStorage(ActivityType.BALLROOM);
            $rootScope.activityType = ActivityType.BALLROOM;
            $rootScope.$broadcast('activityChange');
        };
        $rootScope.loadSpecialOccasionDance = function () {
            setActivityInLocalStorage(ActivityType.SPECIAL_OCCASION);
            $rootScope.activityType = ActivityType.SPECIAL_OCCASION;
            $rootScope.$broadcast('activityChange');
        };
    }]);