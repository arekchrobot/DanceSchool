angular.module("danceSchoolManagement.newsEditController", []).config(function ($stateProvider) {
    $stateProvider.state("newsEdit", {
        url: "/news/:id/edit",
        templateUrl: "html/news/newsEdit.html",
        controller: "newsEditController"
    });
}).controller("newsEditController", function ($scope, $state, $stateParams, newsRestService, exceptionHandler) {

    $scope.editable = true;
    $scope.buttonText = "Zapisz";
    $scope.title = "Edytuj wpis do aktualności";

    newsRestService.get($stateParams.id,
        function(returnedData){
            $scope.news = returnedData;
        },
        exceptionHandler.handleRestError
    );

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