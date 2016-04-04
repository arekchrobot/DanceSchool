angular.module("danceSchoolManagement.authController", []).config(function ($stateProvider) {
    $stateProvider.state("login", {
        url: "/login",
        views: {},
        data: {pageTitle: "Log In"}
    });
}).controller("authController", function ($rootScope, $scope, authService) {

    $scope.credentials = {};

    $scope.authenticate = function (credentials) {
        authService.authenticate(credentials,
            function (returnedData) {
                $rootScope.user = returnedData;
            }, function (returnedData) {
                $rootScope.user = null;
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