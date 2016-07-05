angular.module("danceSchoolManagement.aboutEditController", []).config(function ($stateProvider) {
    $stateProvider.state("aboutEdit", {
        url: "/about/:id/edit",
        templateUrl: "html/about/aboutEdit.html",
        controller: "aboutEditController"
    });
}).controller("aboutEditController", function ($scope, $state, $stateParams, aboutRestService, exceptionHandler) {

    $scope.editable = true;
    $scope.buttonText = "Zapisz";

    aboutRestService.get($stateParams.id,
        function (returnedData) {
            $scope.about = returnedData;
        },
        exceptionHandler.handleRestError
    );

    $scope.doAction = function() {
        aboutRestService.save($scope.about,
            function(returnedData){
                $state.go("about");
            },
            exceptionHandler.handleRestError
        );
    }
});