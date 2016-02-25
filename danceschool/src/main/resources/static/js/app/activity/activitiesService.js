appServices.service('activitiesService', function () {
    var modernTeachers = [];
    modernTeachers[0] = {
        image: 'images/nowoczesny_instruktor1.png',
        name: 'Katarzyna Kowalska',
        description: 'Fascynuje się tańcem od dziecka. Pracuje jako instruktorka tańca nowoczesnego od czterech lat.'
    };
    modernTeachers[1] = {
        image: 'images/nowoczesny_instruktor2.png',
        name: 'Pablo Martinez',
        description: 'Wicemistrz Europy w tańcu nowoczesnym. Instruktor od siedmiu lat.'
    };
    modernTeachers[2] = {
        image: 'images/nowoczesny_instruktor3.png',
        name: 'Aleksandra Jutrzenka',
        description: 'Występowała jako tancerka w trzech edycjach "Tańca z gwiazdami", dwukrotnie przechodząc do finału. Instruktorka od dziesięciu lat.'
    };

    //Ballroom
    var ballroomTeachers = [];
    ballroomTeachers[0] = {
        image: 'images/towarzyski_instruktor1.png',
        name: 'Amanda Piasecka',
        description: 'Wielokrotna mistrzyni Polski w tango oraz walcu. Jako instruktorka wyszkoliła 3 mistrzów świata tańców towarzyskich.'
    };
    ballroomTeachers[1] = {
        image: 'images/towarzyski_instruktor2.png',
        name: 'Martin Egurrola',
        description: 'Tancerz, choreograf, sędzia międzynarodowy tańca towarzyskiego i tańca nowoczesnego. Wielokrotny mistrz Polski w tańcach latynoamerykańskich.'
    };
    ballroomTeachers[2] = {
        image: 'images/towarzyski_instruktor3.png',
        name: 'Drake Graham',
        description: 'Amerykański mistrz tańca towarzyskiego, były instruktor na Broadway w Ameryce. Instruktor od 13 lat.'
    };

    //Special Occasion
    var specialOccasionTeachers = [];
    specialOccasionTeachers[0] = {
        image: 'images/specjalne_instruktor1.png',
        name: 'Dominika Macierewicz',
        description: 'Wielkrotnie tworzyła choreografie na weselach. Pomagała przygotować pierwszy taniec wielu znanym gwiazdom.'
    };
    specialOccasionTeachers[1] = {
        image: 'images/specjalne_instruktor2.png',
        name: 'Justyna Kwak',
        description: 'Specjalizuje się w tańcach studniówkowych. Pottrafi stworzyć zapierające w dech piersiach wariacje, które zapierają dech w piersi.'
    };
    specialOccasionTeachers[2] = {
        image: 'images/specjalne_instruktor3.png',
        name: 'Tatiana Okupnik',
        description: 'Wieloletnia instruktorka, tancerka polskich tradycyjnych tańców. Jej doświadczenie pozwala jej na dostosowanie się do każdej imprezy okolicznościowej'
    };
    return {
        getAllTeachers: function () {
            return ballroomTeachers.concat(modernTeachers, specialOccasionTeachers);
        }
    };
}).factory('activityService', function ($http, dateCacheService, ActivityType, REST_URL, $log, $cacheFactory) {
    var service = {};

    var ACTIVITY_CACHE = "activityCache";
    var ACTIVITY_DATE_CACHE = "activityDateCache";
    var ACTIVITY_URL_CACHE = "activityUrlCache";

    var LESSONS_CACHE = "lessonsCache";
    var LESSONS_DATE_CACHE = "lessonsDateCache";
    var LESSONS_URL_CACHE = "lessonsUrlCache";

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

        if (activity == null || dateCacheService.shouldSynchronize(activityDate)) {
            activity = $http.get(REST_URL + activityUrl)
                .then(function (data) {
                    cache.put(activityType + ACTIVITY_DATE_CACHE, new Date());
                    return data.data;
                },
                function (data) {
                    $log.error('FUCKING ERROR FOR FUCKS SAKE!!!');
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

        if (lessons == null || dateCacheService.shouldSynchronize(lessonsDate)) {
            lessons = $http.get(REST_URL + lessonsUrl)
                .then(function (data) {
                    cache.put(activityType + LESSONS_DATE_CACHE, new Date());
                    return data.data;
                },
                function (data) {
                    $log.error("ERRROOORRR");
                    return null;
                });
        }
        cache.put(activityType + LESSONS_CACHE, lessons);
        return lessons;
    };

    return service;
});