angular.module("danceSchoolManagement.authController", []).config(function ($stateProvider) {
    $stateProvider.state("login", {
        url: "/login",
        templateUrl: "html/auth/login.html"
    });
}).controller("authController", function ($rootScope, $scope, authService, exceptionHandler) {

    $scope.credentials = {};

    $scope.authenticate = function (credentials) {
        authService.authenticate(credentials,
            function (returnedData) {
                $rootScope.user = returnedData;
                $scope.credentials = {};
            }, function (returnedData) {
                //$rootScope.user = null;
                $scope.credentials = {};
                exceptionHandler.handleRestError(returnedData);
            });
    };

    $scope.login = function () {
        $scope.authenticate($scope.credentials);
    };

    authService.isLogged(
        function (returnedData) {
            $rootScope.user = returnedData;
        }, function (returnedData) {
            $rootScope.user = null;
        });

    $scope.logout = function () {
        authService.logout(
            function (returnedData) {
                $rootScope.user = null;
            }, function (returnedData) {
                $rootScope.user = null;
            });
    };
});