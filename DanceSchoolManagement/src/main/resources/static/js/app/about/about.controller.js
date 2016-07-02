angular.module("danceSchoolManagement.aboutController", []).config(function ($stateProvider) {
    $stateProvider.state("about", {
        url: "/about",
        templateUrl: "html/about/about.html",
        controller:"aboutController"
    });
}).controller("aboutController", function ($scope, aboutRestService, exceptionHandler) {
    aboutRestService.getAll(
        function(returnedData){
            $scope.abouts = returnedData;
        },
        exceptionHandler.handleRestError
    );
});