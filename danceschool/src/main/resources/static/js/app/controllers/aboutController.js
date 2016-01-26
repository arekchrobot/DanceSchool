'use strict';

appControllers.controller('aboutController',['$scope', 'activitiesService', function($scope, activitiesService) {
    $scope.allTeachers = activitiesService.getAllTeachers();
}]);