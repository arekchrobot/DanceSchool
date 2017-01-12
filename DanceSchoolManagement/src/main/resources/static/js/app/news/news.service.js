angular.module("danceSchoolManagement.newsServices", [])
    .factory("newsRestService", function (baseRestService) {
        var service = angular.copy(baseRestService);

        service.baseObjectUrl = "/news/";

        return service;
    });