angular.module("danceSchoolManagement.aboutController", []).config(function ($stateProvider) {
    $stateProvider.state("about", {
        url: "/about",
        templateUrl: "html/about/about.html",
        controller:"aboutController"
    });
}).controller("aboutController", function ($scope, aboutRestService, exceptionHandler, ngDialog) {
    aboutRestService.getAll(
        function(returnedData){
            $scope.abouts = returnedData;
        },
        exceptionHandler.handleRestError
    );

    $scope.removeItem = function(item) {
        var dialogData = {
            func: function() {
                aboutRestService.delete(item.id,
                    function(returnedData){
                        aboutRestService.getAll(
                            function(returnedData){
                                $scope.abouts = returnedData;
                            },
                            exceptionHandler.handleRestError
                        );
                    },
                    exceptionHandler.handleRestError
                );
            }
        };
        ngDialog.open({template: "html/util/removeConfirm.html", data: dialogData});
    }
});