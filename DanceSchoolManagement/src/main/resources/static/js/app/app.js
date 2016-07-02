angular.module("danceSchoolManagement", [
    "ngResource",
    "smoothScroll",
    "ui.router",
    "ui.bootstrap",
    "ngDialog",

    "danceSchoolManagement.directives",
    "danceSchoolManagement.baseRestService",
    "danceSchoolManagement.dialogController",
    "danceSchoolManagement.exceptionHandler",
    "danceSchoolManagement.authService",
    "danceSchoolManagement.authController",
    "danceSchoolManagement.aboutServices",
    "danceSchoolManagement.aboutController"

]).config(["$sceDelegateProvider", "$httpProvider", "$urlRouterProvider", function ($sceDelegateProvider, $httpProvider, $urlRouterProvider) {

    $urlRouterProvider.when("/", "login").otherwise("/");
    $httpProvider.defaults.headers.common["X-Requested-With"] = "XMLHttpRequest";

    $sceDelegateProvider
        .resourceUrlWhitelist([
            "self",
            "https://www.youtube.com/embed/**"
        ]);
}]);