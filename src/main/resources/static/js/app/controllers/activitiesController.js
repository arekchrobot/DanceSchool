'use strict';

appControllers.controller('activitiesController',['$scope', 'activitiesService', function($scope, activitiesService){
    $scope.alert = function(id){
        alert('Dziękujemy za zapisanie się');
        $('#'+id).hide();
    };

    $scope.teachers = activitiesService.getTeachers();
    $scope.video = activitiesService.getVideo();
    $scope.gallery = activitiesService.getGallery();
    $scope.danceType = activitiesService.getDanceType();
}]);