appServices.factory('aboutService', function($http, dateCacheService, REST_URL, $cacheFactory, $log){
    var service = {};

    var ABOUT_TEACHERS_CACHE = "aboutTeachersCache";
    var ABOUT_TEACHERS_DATE_CACHE = "aboutTeachersDateCache";

    var ABOUT_CACHE = "aboutCache";
    var ABOUT_DATE_CACHE = "aboutDateCache";

    var CACHE_TIME_MIN = 5;
    var ABOUT_CACHE_TIME_MIN = 120;

    service.cache = $cacheFactory("aboutCacheId");

    service.loadInstructors = function () {
        var cache = this.cache;

        var instructors = cache.get(ABOUT_TEACHERS_CACHE);
        var instructorsDate = cache.get(ABOUT_TEACHERS_DATE_CACHE);

        if (instructors == null || dateCacheService.shouldSynchronize(instructorsDate, CACHE_TIME_MIN)) {
            instructors = $http.get(REST_URL + "instructors")
                .then(function (response) {
                    cache.put(ABOUT_TEACHERS_DATE_CACHE, new Date());
                    return response.data;
                },
                function (response) {
                    $log.error("Could not load instructors data from: " + REST_URL + "instructors");
                    return null;
                });
        }
        cache.put(ABOUT_TEACHERS_CACHE, instructors);
        return instructors;
    };

    service.loadAbout = function () {
        var cache = this.cache;

        var about = cache.get(ABOUT_CACHE);
        var aboutDate = cache.get(ABOUT_DATE_CACHE);

        if (about == null || dateCacheService.shouldSynchronize(aboutDate, ABOUT_CACHE_TIME_MIN)) {
            about = $http.get(REST_URL + "about")
                .then(function (response) {
                    cache.put(ABOUT_DATE_CACHE, new Date());
                    return response.data;
                },
                function (response) {
                    $log.error("Could not load about data from: " + REST_URL + "about");
                    return null;
                });
        }
        cache.put(ABOUT_CACHE, about);
        return about;
    };

    return service;
});