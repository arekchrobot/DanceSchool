angular.module("danceSchoolManagement.contactServices", [])
    .factory("contactRestService", function (baseRestService) {
        var service = angular.copy(baseRestService);

        service.baseObjectUrl = "/contact/";

        return service;
    })
    .factory("contactService", function ($http, exceptionHandler) {
        var service = {};

        service.getLatLng = function(contactData, successFunction) {
            var address = contactData.address + "," + contactData.city;
            var restUrl = 'https://maps.googleapis.com/maps/api/geocode/json?address=' + address + '&key=****';
            $http.get(restUrl,{})
                .success(successFunction)
                .error(exceptionHandler.handleRestError);
        };

        return service;
    });