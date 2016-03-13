appServices.factory('mainService', function ($http, dateCacheService, REST_URL, $log, $cacheFactory) {
    var service = {};

    var NEWS_CACHE = "newsCache";
    var NEWS_DATE_CACHE = "newsDateCache";

    var CACHE_TIME_MIN = 5;

    service.cache = $cacheFactory("newsCacheId");

    service.loadNews = function() {
        var cache = this.cache;

        var news = cache.get(NEWS_CACHE);
        var newsDate = cache.get(NEWS_DATE_CACHE);

        if(news == null || dateCacheService.shouldSynchronize(newsDate, CACHE_TIME_MIN)) {
            news = $http.get(REST_URL + "news")
                .then(function(response){
                    cache.put(NEWS_DATE_CACHE, new Date());
                    return response.data;
                },
                function(response){
                    $log.error("Could not load news data from: " + REST_URL + "news");
                    return null;
                });
        }
        cache.put(NEWS_CACHE, news);
        return news;
    };

    return service;
});