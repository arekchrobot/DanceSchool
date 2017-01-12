angular.module("danceSchoolManagement.aboutServices", [])
    .factory("aboutRestService", function (baseRestService) {
        var service = angular.copy(baseRestService);

        service.baseObjectUrl = "/about/";

        return service;
    });