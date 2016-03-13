'use strict';

appControllers.controller('aboutController',['$scope', 'aboutService', '$log', function($scope, aboutService, $log) {
    var loadTeachers = function () {
        aboutService.loadInstructors()
            .then(function (data) {
                $scope.allTeachers = data;
            },
            function (data) {
                $log.error("Error getting instructors");
            });
    };

    var loadAbout = function () {
        aboutService.loadAbout()
            .then(function (data) {
                $scope.abouts = data;
            },
            function (data) {
                $log.error("Error getting about");
            });
    };

    loadTeachers();
    loadAbout();
}]);