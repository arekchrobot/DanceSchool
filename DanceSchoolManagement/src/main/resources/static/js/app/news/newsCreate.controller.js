angular.module("danceSchoolManagement.newsCreateController", []).config(function ($stateProvider) {
    $stateProvider.state("newsCreate", {
        url: "/news/create",
        templateUrl: "html/news/newsEdit.html",
        controller: "newsCreateController"
    });
}).controller("newsCreateController", function ($scope, $state, $stateParams, newsRestService, exceptionHandler) {

    $scope.editable = true;
    $scope.buttonText = "Stwórz";
    $scope.title = "Dodaj nowy wpis do aktualności";

    $scope.news = {};
    $scope.news.news = {};

    $scope.doAction = function() {
        newsRestService.save($scope.news,
            function(returnedData){
                $state.go("news");
            },
            exceptionHandler.handleRestError
        );
    };

    $scope.uploadFile = function(input) {
        if (input.files && input.files[0]) {
            $scope.news.news.image = input.files[0].name;
            var reader = new FileReader();
            reader.onload = function (e) {
                //imageElement.setAttribute('src', e.target.result);
                $scope.news.image = e.target.result.replace(/(data:image\/jpeg;base64,)/g, "");
                $scope.$apply();
            };
            reader.readAsDataURL(input.files[0]);
        }
    }
});