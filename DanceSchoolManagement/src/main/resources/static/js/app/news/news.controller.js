angular.module("danceSchoolManagement.newsController", []).config(function ($stateProvider) {
    $stateProvider.state("news", {
        url: "/news",
        templateUrl: "html/news/news.html",
        controller:"newsController"
    });
}).controller("newsController", function ($scope, newsRestService, exceptionHandler, ngDialog) {
    newsRestService.getAll(
        function(returnedData){
            $scope.newsWrappers = returnedData;
        },
        exceptionHandler.handleRestError
    );

    $scope.removeItem = function(item) {
        var dialogData = {
            func: function() {
                newsRestService.delete(item.id,
                    function(returnedData){
                        newsRestService.getAll(
                            function(returnedData){
                                $scope.newsWrappers = returnedData;
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