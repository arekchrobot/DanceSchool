appServices.service('dateCacheService', function($log) {
    
    var cacheTimeMin = 5;
    var shouldSynchronize = function(lastSynchronizationDate) {
        if(lastSynchronizationDate != null) {
            $log.info("inside the cache");
            var currentDate = new Date();

            var millisecondsDiff = currentDate - lastSynchronizationDate;
            var minutesDiff = millisecondsDiff/(1000*60);
            $log.info("Minutes diff: " + minutesDiff);
            $log.info("Should sync: " + minutesDiff >= cacheTimeMin);
            return minutesDiff >= cacheTimeMin;
        }
        $log.info("just the first time baby");
        return true;
    };
    
    return {
        shouldSynchronize : shouldSynchronize
    };
});