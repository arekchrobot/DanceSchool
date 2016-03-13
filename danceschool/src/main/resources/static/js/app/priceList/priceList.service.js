appServices.factory('priceListService', function ($http, dateCacheService, REST_URL, $cacheFactory, $log) {
    var service = {};

    var PRICE_LIST_CACHE = "priceListCache";
    var PRICE_LIST_DATE_CACHE = "priceListDateCache";

    var CACHE_TIME_MIN = 5;

    service.cache = $cacheFactory("priceListCacheId");

    service.loadLessons = function () {
        var cache = this.cache;

        var lessons = cache.get(PRICE_LIST_CACHE);
        var lessonsDate = cache.get(PRICE_LIST_DATE_CACHE);

        if (lessons == null || dateCacheService.shouldSynchronize(lessonsDate, CACHE_TIME_MIN)) {
            lessons = $http.get(REST_URL + "lessons/all")
                .then(function (response) {
                    cache.put(PRICE_LIST_DATE_CACHE, new Date());
                    return response.data;
                },
                function (response) {
                    $log.error("Could not load lessons data from: " + REST_URL + "lessons/all");
                    return null;
                });
        }
        cache.put(PRICE_LIST_CACHE, lessons);
        return lessons;
    };

    return service;
});