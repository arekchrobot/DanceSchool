'use strict';

appControllers.controller('activitiesController', ['$scope', '$rootScope', '$sce', '$http', 'activitiesService', 'ActivityType', '$log', function ($scope, $rootScope, $sce, $http, activitiesService, ActivityType, $log) {
    $scope.alert = function (id) {
        alert('Dziękujemy za zapisanie się');
        $('#' + id).hide();
    };

    $scope.activity = {};

    var loadActivity = function (activityType) {
        activitiesService.loadActivity(activityType)
            .async()
            .then(function (data) {
                $scope.activity = data;
            },
            function (data) {
                $log.info('DAAMN!!1');
            });
    };
    
    var loadActivityV2 = function(activityType) {
        activitiesService.loadActivityV2(activityType)
                .then(function(data) {
                    $scope.activity = data;
                },
                function (data) {
                    $log.info('DAAMN!!1');
                });
    }

    loadActivity($rootScope.activityType);

    function arrayBufferToBase64(buffer) {
        var binary = '';
        var bytes = new Uint8Array(buffer);
        var len = bytes.byteLength;
        for (var i = 0; i < len; i++) {
            binary += String.fromCharCode(bytes[i]);
        }
        return window.btoa(binary);
    };

//    $http.get('http://localhost:8080/image', {responseType: "arraybuffer"}).success(function (data) {
//        $scope.testImg = 'data:image/png;base64,' + arrayBufferToBase64(data);
//    }).error(function (data) {
////        alert('OH FUCK!');
//    });
//
//    $http.get('http://localhost:8080/test').success(function (response) {
//        $scope.wtf = response;
//    });
//
//    $http.get('http://localhost:8080/test2').success(function (response) {
//        $scope.wtf2 = response;
//    });

    $scope.teachers = activitiesService.getTeachers();
    $scope.video = $sce.trustAsResourceUrl(activitiesService.getVideo());
    $scope.gallery = activitiesService.getGallery();
    $scope.danceType = activitiesService.getDanceType();
    //$scope.activitiesService = activitiesService;

    $rootScope.$on('activitiesLoaded', function () {
        $scope.teachers = activitiesService.getTeachers();
        $scope.video = $sce.trustAsResourceUrl(activitiesService.getVideo());
        $scope.gallery = activitiesService.getGallery();
        $scope.danceType = activitiesService.getDanceType();
        //   $scope.activitiesService = activitiesService;
        for (var id = 1; id < 7; id++) {
            $('#b' + id).show();
        }
    });

    $rootScope.$on('activityChange', function () {
        loadActivityV2($rootScope.activityType);
    });

}]);