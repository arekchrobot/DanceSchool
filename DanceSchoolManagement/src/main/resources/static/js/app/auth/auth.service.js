angular.module("danceSchoolManagement.authService",[])
    .factory("authService", function ($http) {
        var service = {};

        service.authenticate = function(credentials, successFunction, failureFunction) {
            var headers = credentials ? {
                authorization: "Basic "
                + btoa(credentials.username + ":" + credentials.password)
            } : {};

            $http.get('/login/user', {headers: headers})
                .success(successFunction)
                .error(failureFunction);
        };

        service.logout = function(successFunction, failureFunction) {
            $http.post('/auth/logout', {})
                .success(successFunction)
                .error(failureFunction);
        };

        return service;
    });