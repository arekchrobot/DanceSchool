angular.module("danceSchoolManagement", [
    "ngResource",
    "smoothScroll",
    "ui.router",

    "danceSchoolManagement.authService",
    "danceSchoolManagement.authController"

]).config(["$sceDelegateProvider", "$httpProvider", "$urlRouterProvider", function ($sceDelegateProvider, $httpProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise("/");
    $httpProvider.defaults.headers.common["X-Requested-With"] = "XMLHttpRequest";

    $sceDelegateProvider
        .resourceUrlWhitelist([
            "self",
            "https://www.youtube.com/embed/**"
        ]);
}]).controller("login", function ($rootScope, $scope, $resource, $http) {
    var authenticate = function (credentials, callback) {

        var headers = credentials ? {
            authorization: "Basic "
            + btoa(credentials.username + ":" + credentials.password)
        } : {};

        $http.get('/user', {headers: headers}).success(function (data) {
            if (data.username) {
                $rootScope.authenticated = true;
            } else {
                $rootScope.authenticated = false;
            }
            callback && callback();
        }).error(function () {
            $rootScope.authenticated = false;
            callback && callback();
        });

    };

    authenticate();
    $scope.credentials = {};
    $scope.login = function () {
        authenticate($scope.credentials, function () {
            if ($rootScope.authenticated) {
                $scope.error = false;
            } else {
                $scope.error = true;
            }
        });
        $scope.getMyData();
    };

    $scope.getMyData = function () {
        $http.get('/secured/user').success(function (data) {
            $rootScope.woot = "woot";
        }).error(function () {
            $rootScope.woot = "nope";
        });
    };

    $scope.getMyData();

    $scope.logout = function () {
        $http.post('/logout', {}).success(function () {
            $rootScope.authenticated = false;
            $location.path("/");
        }).error(function (data, status) {
            alert(status);
            $rootScope.authenticated = false;
        });
    };
});