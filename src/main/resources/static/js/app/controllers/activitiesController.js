'use strict';

appControllers.controller('activitiesController',['$scope',function($scope){
    $scope.alert = function(id){
        alert('Dziękujemy za zapisanie się');
        $('#'+id).hide();
    };
}]);