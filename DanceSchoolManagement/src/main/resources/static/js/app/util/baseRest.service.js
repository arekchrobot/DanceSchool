angular.module("danceSchoolManagement.baseRestService", [])
    .factory("baseRestService", function ($http) {
        var service = {};

        /*
         * This needs to be changed by inherited object to make REST work properly
         * It represents the url for object we want to fetch
         * Example: if we want about rest api then this value should be "about/"
         */
        service.baseObjectUrl = "/";

        service.get = function (id, successFunction, failureFunction) {
            $http.get(this.baseObjectUrl + id, {})
                .success(successFunction)
                .error(failureFunction);
        };

        service.getAll = function (successFunction, failureFunction) {
            $http.get(this.baseObjectUrl, {})
                .success(successFunction)
                .error(failureFunction);
        };

        service.save = function (data, successFunction, failureFunction) {
            $http.post(this.baseObjectUrl, data)
                .success(successFunction)
                .error(failureFunction);
        };

        service.delete = function (id, successFunction, failureFunction) {
            $http.delete(this.baseObjectUrl + id, {})
                .success(successFunction)
                .error(failureFunction);
        };

        return service;
    });