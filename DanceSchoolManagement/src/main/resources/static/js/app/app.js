angular.module("danceSchoolManagement", [
    "ngResource",
    "smoothScroll",
    "ui.router",
    "ui.bootstrap",
    "ngDialog",
    "smart-table",

    "danceSchoolManagement.directives",
    "danceSchoolManagement.filters",
    "danceSchoolManagement.baseRestService",
    "danceSchoolManagement.dialogController",
    "danceSchoolManagement.exceptionHandler",

    "danceSchoolManagement.authService",
    "danceSchoolManagement.authController",

    "danceSchoolManagement.aboutServices",
    "danceSchoolManagement.aboutController",
    "danceSchoolManagement.aboutEditController",
    "danceSchoolManagement.aboutCreateController",

    "danceSchoolManagement.contactServices",
    "danceSchoolManagement.contactController",

    "danceSchoolManagement.newsServices",
    "danceSchoolManagement.newsController"

]).config(["$sceDelegateProvider", "$httpProvider", "$urlRouterProvider", function ($sceDelegateProvider, $httpProvider, $urlRouterProvider) {

    $urlRouterProvider.when("/", "login").otherwise("/");
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
    //$httpProvider.defaults.headers.common["X-Requested-With"] = "XMLHttpRequest";

    $sceDelegateProvider
        .resourceUrlWhitelist([
            "self",
            "https://www.youtube.com/embed/**"
        ]);
}]);