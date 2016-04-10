angular.module('danceSchoolManagement.exceptionHandler', []).factory('exceptionHandler', function ($state, $rootScope, ngDialog) {
    var service = {};

    service.handleRestError = function (error) {
        if (error.status !== undefined && error.status === 401) {
            $rootScope.user = null;
            ngDialog.open({template: "html/error/unauthorized.html"});
            $state.go("login");
        }
    };

    return service;
});