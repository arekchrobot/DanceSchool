angular.module('danceSchoolManagement.exceptionHandler', []).factory('exceptionHandler', function ($state, $rootScope, ngDialog) {
    var service = {};

    service.handleRestError = function (error) {
        if (error.status !== undefined && error.status === 401) {
            $rootScope.user = null;
            ngDialog.open({template: "html/error/unauthorized.html"});
            $state.go("login");
        } else if(error.status !== undefined) {
            var data = {};
            switch(error.status) {
                case 400:
                    data.title = "Niepoprawne żądanie";
                    break;
                case 403:
                    data.title = "Nie masz uprawnień do wykonania tej czynności";
                    break;
                case 404:
                    data.title = "Nie znaleziono";
                    break;
                case 500:
                    data.title = "Błąd systemu";
                    break;
            }
            data.description = error.description;
            ngDialog.open({template: "html/error/error.html", data: data});
        }
    };

    return service;
});