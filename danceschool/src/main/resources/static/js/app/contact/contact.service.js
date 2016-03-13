appServices.factory('contactService', function ($http, dateCacheService, REST_URL, $log, $cacheFactory) {
    var service = {};

    var CONTACT_CACHE = "contactCache";
    var CONTACT_DATE_CACHE = "contactDateCache";

    var CACHE_TIME_MIN = 60;

    service.cache = $cacheFactory("contactCacheId");

    service.loadContact = function() {
        var cache = this.cache;

        var contact = cache.get(CONTACT_CACHE);
        var contactDate = cache.get(CONTACT_DATE_CACHE);

        if(contact == null || dateCacheService.shouldSynchronize(contactDate, CACHE_TIME_MIN)) {
            contact = $http.get(REST_URL + "contact")
                .then(function(response){
                    cache.put(CONTACT_DATE_CACHE, new Date());
                    return response.data;
                },
                function(response){
                    $log.error("Could not load contact data from: " + REST_URL + "contact");
                    return null;
                });
        }
        cache.put(CONTACT_CACHE, contact);
        return contact;
    };

    return service;
});