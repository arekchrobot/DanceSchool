angular.module("danceSchoolManagement.authService",[])
    .factory("authService", function ($http) {
        var service = {};

        service.authenticate = function(credentials, successFunction, failureFunction) {
            $http.post('/auth/login', credentials)
                .success(successFunction)
                .error(failureFunction);
        };

        service.logout = function(successFunction, failureFunction) {
            $http.post('/auth/logout', {})
                .success(successFunction)
                .error(failureFunction);
        };

        service.isLogged = function(successFunction, failureFunction) {
            $http.get("/auth/logged",{})
                .success(successFunction)
                .error(failureFunction);
        };

        return service;
    });