appServices.factory('activityService', function ($http, dateCacheService, ActivityType, REST_URL, $log, $cacheFactory) {
    var service = {};

    var ACTIVITY_CACHE = "activityCache";
    var ACTIVITY_DATE_CACHE = "activityDateCache";
    var ACTIVITY_URL_CACHE = "activityUrlCache";

    var LESSONS_CACHE = "lessonsCache";
    var LESSONS_DATE_CACHE = "lessonsDateCache";
    var LESSONS_URL_CACHE = "lessonsUrlCache";

    var CACHE_TIME_MIN = 5;

    service.cache = $cacheFactory("activityCacheId");

    service.cache.put(ActivityType.MODERN + ACTIVITY_URL_CACHE, "activity?activity_name=Taniec+nowoczesny");
    service.cache.put(ActivityType.BALLROOM + ACTIVITY_URL_CACHE, "activity?activity_name=Taniec+towarzyski");
    service.cache.put(ActivityType.SPECIAL_OCCASION + ACTIVITY_URL_CACHE, "activity?activity_name=Specjalne+okazje");

    service.cache.put(ActivityType.MODERN + LESSONS_URL_CACHE, "lessons?activity_name=Taniec+nowoczesny");
    service.cache.put(ActivityType.BALLROOM + LESSONS_URL_CACHE, "lessons?activity_name=Taniec+towarzyski");
    service.cache.put(ActivityType.SPECIAL_OCCASION + LESSONS_URL_CACHE, "lessons?activity_name=Specjalne+okazje");

    service.loadCacheActivity = function (activityType) {
        var cache = this.cache;
        var activity = this.cache.get(activityType + ACTIVITY_CACHE);
        var activityDate = this.cache.get(activityType + ACTIVITY_DATE_CACHE);
        var activityUrl = this.cache.get(activityType + ACTIVITY_URL_CACHE);

        if (activity == null || dateCacheService.shouldSynchronize(activityDate, CACHE_TIME_MIN)) {
            activity = $http.get(REST_URL + activityUrl)
                .then(function (response) {
                    cache.put(activityType + ACTIVITY_DATE_CACHE, new Date());
                    return response.data;
                },
                function (response) {
                    $log.error("Could not load activity from: " + REST_URL + activityUrl);
                    return null;
                });
        }
        cache.put(activityType + ACTIVITY_CACHE, activity);
        return activity;
    };

    service.loadCacheLessons = function (activityType) {
        var cache = this.cache;
        var lessons = this.cache.get(activityType + LESSONS_CACHE);
        var lessonsDate = this.cache.get(activityType + LESSONS_DATE_CACHE);
        var lessonsUrl = this.cache.get(activityType + LESSONS_URL_CACHE);

        if (lessons == null || dateCacheService.shouldSynchronize(lessonsDate, CACHE_TIME_MIN)) {
            lessons = $http.get(REST_URL + lessonsUrl)
                .then(function (response) {
                    cache.put(activityType + LESSONS_DATE_CACHE, new Date());
                    return response.data;
                },
                function (response) {
                    $log.error("Could not load lessons from: " + REST_URL + lessonsUrl);
                    return null;
                });
        }
        cache.put(activityType + LESSONS_CACHE, lessons);
        return lessons;
    };

    return service;
});