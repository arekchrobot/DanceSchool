'use strict';

appControllers.controller('activitiesController',['$scope', '$rootScope','$sce', 'activitiesService', function($scope, $rootScope, $sce, activitiesService){
    $scope.alert = function(id){
        alert('Dziękujemy za zapisanie się');
        $('#'+id).hide();
    };

    $scope.teachers = activitiesService.getTeachers();
    $scope.video =  $sce.trustAsResourceUrl(activitiesService.getVideo());
    $scope.gallery = activitiesService.getGallery();
    $scope.danceType = activitiesService.getDanceType();
    //$scope.activitiesService = activitiesService;

    $rootScope.$on('activitiesLoaded', function() {
        $scope.teachers = activitiesService.getTeachers();
        $scope.video = $sce.trustAsResourceUrl(activitiesService.getVideo());
        $scope.gallery = activitiesService.getGallery();
        $scope.danceType = activitiesService.getDanceType();
     //   $scope.activitiesService = activitiesService;
        for (var id=1; id <7; id++) {
            $('#b'+id).show();
        }
    });

}]);