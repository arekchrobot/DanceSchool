'use strict';

appControllers.controller('priceListController', ['$scope', 'priceListService', '$log', function ($scope, priceListService, $log) {
    var loadLessons = function () {
        priceListService.loadLessons()
            .then(function (data) {
                $scope.lessons = data;
            },
            function (data) {
                $log.error("Error getting lessons");
            });
    };

    loadLessons();
}]);