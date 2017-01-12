angular.module("danceSchoolManagement.aboutCreateController", []).config(function ($stateProvider) {
    $stateProvider.state("aboutCreate", {
        url: "/about/create",
        templateUrl: "html/about/aboutEdit.html",
        controller: "aboutCreateController"
    });
}).controller("aboutCreateController", function ($scope, $state, $stateParams, aboutRestService, exceptionHandler) {

    $scope.editable = true;
    $scope.buttonText = "Stwórz";
    $scope.title = "Dodaj dane o szkole";

    $scope.about = {};

    $scope.doAction = function() {
        aboutRestService.save($scope.about,
            function(returnedData){
                $state.go("about");
            },
            exceptionHandler.handleRestError
        );
    }
});