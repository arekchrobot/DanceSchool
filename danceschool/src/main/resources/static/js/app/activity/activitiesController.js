'use strict';

appControllers.controller('activitiesController', ['$scope', '$rootScope', '$sce', '$http', 'ActivityType', '$log', 'activityService', 'localStorageService',
    function ($scope, $rootScope, $sce, $http, ActivityType, $log, activityService, localStorageService) {
        $scope.alert = function (id) {
            alert('Dziękujemy za zapisanie się');
            $('#' + id).hide();
        };

        $scope.activity = {};
        $scope.lessons = {};

        $scope.myLovelyAss = {};
        $scope.myLovelyAss.ass = 'dfdsdsds1111';

        var loadLessons = function (activityType) {
            activityService.loadCacheLessons(activityType)
                .then(function (data) {
                    $scope.lessons = data;
                },
                function (data) {
                    $log.info("DAMN!");
                });
        };

        var loadActivity = function (activityType) {
            activityService.loadCacheActivity(activityType)
                .then(function (data) {
                    $scope.activity = data;
                },
                function (data) {
                    $log.info('DAAMN!!1');
                });
        };

        $scope.activityType = localStorageService.isSupported ? localStorageService.get('activityType') : $rootScope.activityType;

        loadActivity($scope.activityType);
        loadLessons($scope.activityType);

        $rootScope.$on('activityChange', function () {
            var activityType = localStorageService.isSupported ? localStorageService.get('activityType') : $rootScope.activityType;
            loadActivity(activityType);
            loadLessons(activityType);
        });

    }]);